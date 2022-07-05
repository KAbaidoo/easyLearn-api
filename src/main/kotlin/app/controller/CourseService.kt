package app.controller

import app.CourseRepository
import app.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService(val db: CourseRepository) {


    fun findRandom(): Course {
        val courses: MutableIterable<Course> = db.findAll()
        val course = courses.run {
            var index: Int = (0 until this.count()).random()
                this.elementAt(index)
        }
        return course
    }


    fun findCourses() = db.findAll()

    fun addCourse(course: Course) = db.save(course)

    fun updateCourse(id: String, course: Course) {
        if (db.existsById(id)) {
            db.deleteById(id)
            db.save(course)
        }
    }

    fun removeCourse(id: String) = db.deleteById(id)

    fun findCourseById(id: String) = db.findById(id)
    fun addAllCourses(courses: List<Course>) = db.saveAll(courses)
}