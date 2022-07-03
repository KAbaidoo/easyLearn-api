package app.controller

import app.CourseRepository
import app.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService(val db: CourseRepository) {

    fun findCourses() = db.findAll()

    fun addCourse(course: Course) = db.save(course)

    fun updateCourse(id: String, course: Course) {
        if (db.existsById(id)) {
            db.deleteById(id)
            db.save(course)
        }
    }
    fun removeCourse(id: String) = db.deleteById(id)

    fun getCourseById(id: String) = db.findById(id)
    fun addAllCourses(courses: List<Course>) = db.saveAll(courses)
}