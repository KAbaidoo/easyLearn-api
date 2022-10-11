package app.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("COURSES")
data class Course(
    @Id val id: String?,
    val title: String,
    val about: String,
    val offered: String,
    val banner: String,
    val rating: Float,
    val price: Float,
    val modules: Int,
    val cpd: Int,
    val duration: Int
)