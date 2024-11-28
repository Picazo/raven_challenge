package com.juliopicazo.data.networking.model

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("exhaustive")
    val exhaustive: Exhaustive,
    @SerializedName("exhaustiveNbHits")
    val exhaustiveNbHits: Boolean,
    @SerializedName("exhaustiveTypo")
    val exhaustiveTypo: Boolean,
    @SerializedName("hits")
    val hits: List<Hit>,
    @SerializedName("hitsPerPage")
    val hitsPerPage: Int,
    @SerializedName("nbHits")
    val nbHits: Int,
    @SerializedName("nbPages")
    val nbPages: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("params")
    val params: String,
    @SerializedName("processingTimeMS")
    val processingTimeMS: Int,
    @SerializedName("query")
    val query: String,
    @SerializedName("serverTimeMS")
    val serverTimeMS: Int
)

data class Exhaustive(
    @SerializedName("nbHits")
    val nbHits: Boolean,
    @SerializedName("typo")
    val typo: Boolean
)

data class Hit(
    @SerializedName("_highlightResult")
    val highlightResult: HighlightResult?,
    @SerializedName("_tags")
    val tags: List<String>,
    @SerializedName("author")
    val author: String,
    @SerializedName("comment_text")
    val commentText: String?,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("created_at_i")
    val createdAtI: Int,
    @SerializedName("num_comments")
    val numComments: Int?,
    @SerializedName("objectID")
    val objectId: String,
    @SerializedName("parent_id")
    val parentId: Int?,
    @SerializedName("points")
    val points: Int?,
    @SerializedName("story_id")
    val storyId: Int?,
    @SerializedName("story_title")
    val storyTitle: String?,
    @SerializedName("story_url")
    val storyUrl: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("url")
    val url: String?
)

data class HighlightResult(
    @SerializedName("author")
    val author: HighlightDetail?,
    @SerializedName("comment_text")
    val commentText: HighlightDetail?,
    @SerializedName("story_title")
    val storyTitle: HighlightDetail?,
    @SerializedName("story_url")
    val storyUrl: HighlightDetail?
)

data class HighlightDetail(
    @SerializedName("matchLevel")
    val matchLevel: String,
    @SerializedName("matchedWords")
    val matchedWords: List<String>,
    @SerializedName("value")
    val value: String
)