package com.juliopicazo.ravenchallenge.ui.screen.news.mapper

import com.juliopicazo.domain.model.New
import com.juliopicazo.ravenchallenge.ui.screen.news.model.NewUi
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun New.toUi(): NewUi {
    return NewUi(
        id = this.id,
        title = this.title,
        comment = this.comment,
        author = this.author,
        createdAt = this.createdAt.formatTime(),
        url = this.url
    )
}


fun String.formatTime(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    sdf.timeZone = TimeZone.getTimeZone("UTC")

    try {
        val date = sdf.parse(this) ?: return this
        val now = Date()

        val diffInMillis = now.time - date.time
        val diffInSeconds = diffInMillis / 1000
        val diffInMinutes = diffInSeconds / 60
        val diffInHours = diffInMinutes / 60
        val diffInDays = diffInHours / 24

        return when {
            diffInSeconds < 60 -> "${diffInSeconds}s"
            diffInMinutes < 60 -> "${diffInMinutes}m"
            diffInHours < 24 -> "${diffInHours}h"
            diffInDays == 1L -> "Yesterday"
            else -> {
                val formatter = SimpleDateFormat("dd - MM - yyyy", Locale.getDefault())
                formatter.format(date)
            }
        }
    } catch (e: Exception) {
        return this
    }
}