package app.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("LESSONS")
data class Lesson(
    @Id val id: String?,
    val courseId: String,
    val title: String,
    val src: String,
    val duration: Long,
    val lesson: Int
)