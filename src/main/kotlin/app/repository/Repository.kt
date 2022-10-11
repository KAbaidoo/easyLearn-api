package app.repository

import app.model.Course
import app.model.Lesson
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param

interface CourseRepository : PagingAndSortingRepository<Course, String> {

    @Query("SELECT * FROM courses c WHERE LOWER(c.title) LIKE LOWER('%'||:queryString||'%') ORDER BY c.title ASC")
    fun searchCourses(@Param("queryString") queryString: String): MutableIterable<Course>
}

interface LessonRepository : PagingAndSortingRepository<Lesson, String>