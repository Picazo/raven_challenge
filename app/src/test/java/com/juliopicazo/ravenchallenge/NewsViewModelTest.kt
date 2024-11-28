package com.juliopicazo.ravenchallenge

import com.juliopicazo.domain.interactor.DeleteNewUseCase
import com.juliopicazo.domain.interactor.GetNewsUseCase
import com.juliopicazo.domain.model.New
import com.juliopicazo.domain.utils.Resource
import com.juliopicazo.ravenchallenge.ui.screen.news.NewsViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.Mockito.`when`
import org.mockito.kotlin.mock

class NewsViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: NewsViewModel
    private lateinit var getNewsUseCase: GetNewsUseCase
    private lateinit var deleteNewUseCase: DeleteNewUseCase

    @Before
    fun setup() {
        getNewsUseCase = mock()
        deleteNewUseCase = mock()
        viewModel = NewsViewModel(getNewsUseCase, deleteNewUseCase)
    }

    @Test
    fun `getNews should update UI state with empty list when service returns empty data`() =
        runTest {
            // Given
            val mockNews = emptyList<New>()
            val flow = flow {
                emit(Resource.loading())
                emit(Resource.success(mockNews))
            }
            `when`(getNewsUseCase()).thenReturn(flow)

            // When
            viewModel.getNews()

            // Then
            assertEquals(false, viewModel.uiState.value.loading)
            assertEquals(false, viewModel.uiState.value.refreshing)
            assertTrue(viewModel.uiState.value.news.isEmpty())
        }

    @Test
    fun `getNews should update UI state with error when service fails`() = runTest {
        // Given
        val errorMessage = "Error message"
        val flow = flow<Resource<List<New>>> {
            emit(Resource.loading())
            emit(Resource.error(errorMessage))
        }
        `when`(getNewsUseCase()).thenReturn(flow)

        // When
        viewModel.getNews()

        // Then
        assertEquals(false, viewModel.uiState.value.loading)
        assertEquals(false, viewModel.uiState.value.refreshing)
        assertTrue(viewModel.uiState.value.news.isEmpty())
    }
}