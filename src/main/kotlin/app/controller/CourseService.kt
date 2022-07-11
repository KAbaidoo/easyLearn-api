package app.controller

import app.model.Course
import app.repository.CourseRepository
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

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


    fun findAllCourses() = db.findAll()



    fun addCourse(course: Course): Course = db.save(course)

    fun updateCourse(id: String, payload: Course): Course {
        return if (db.existsById(id)) {
            db.save(
                Course(
                    id = payload.id,
                    title = payload.title,
                    about = payload.about,
                    offered = payload.offered,
                    banner = payload.banner,
                    rating = payload.rating,
                    price = payload.price,
                    modules = payload.modules,
                    cpd = payload.cpd,
                    duration = payload.duration
                )
            )
        } else throw ResponseStatusException(HttpStatus.NOT_FOUND,"The id: $id does not exist")

    }

    fun removeCourse(id: String) = db.deleteById(id)

    fun findCourseById(id: String) = db.findById(id)
    fun addCourses(courses: List<Course>) = db.saveAll(courses)


//    get courses sorted by rating

    fun findAllSorted(property: String): MutableIterable<Course> {
        val sort: Sort = Sort.by(Sort.Direction.DESC, property)
       return db.findAll(sort)
    }

//    fun pagedCourses() {
//        val pageable: PageRequest = PageRequest.of(0, 3)
////        each page should have 3 courses
//        db.findAll(pageable)
//    }


}