package com.juliopicazo.ravenchallenge.ui.screen.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juliopicazo.domain.interactor.DeleteNewUseCase
import com.juliopicazo.domain.interactor.GetNewsUseCase
import com.juliopicazo.domain.utils.Status
import com.juliopicazo.ravenchallenge.ui.screen.news.mapper.toUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
    private val deleteNewUseCase: DeleteNewUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(NewsUiState())
    val uiState = _uiState.asStateFlow()


    fun getNews(isRefreshing: Boolean = false) {
        viewModelScope.launch(Dispatchers.IO) {
            getNewsUseCase().collectLatest { result ->
                when (result.status) {
                    Status.SUCCESS -> {
                        val news = result.data ?: emptyList()
                        _uiState.update {
                            it.copy(
                                loading = false,
                                refreshing = false,
                                news = news.map { new -> new.toUi() },
                            )
                        }
                    }

                    Status.LOADING -> {
                        _uiState.update {
                            if (isRefreshing) {
                                it.copy(refreshing = true)
                            } else {
                                it.copy(loading = true)
                            }
                        }
                    }

                    Status.ERROR -> {
                        _uiState.update {
                            it.copy(loading = false, refreshing = false)
                        }
                    }
                }
            }
        }
    }

    fun deleteNew(newId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteNewUseCase(newId).collectLatest { result ->
                when (result.status) {
                    Status.SUCCESS -> {
                        val news = result.data ?: emptyList()
                        _uiState.update {
                            it.copy(news = news.map { new -> new.toUi() })
                        }
                    }

                    Status.ERROR -> {
                        _uiState.update {
                            it.copy(error = result.message)
                        }
                    }

                    else -> {
                        //TODO
                    }
                }
            }
        }
    }


}