package app


import app.model.Course
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import java.sql.Date
import java.sql.Time


@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

interface CourseRepository : CrudRepository<Course, String>

interface ActivityRepository : CrudRepository<Activity, String>


@Table("ACTIVITIES")
data class Activity(
    @Id val id: String?,
    val courseId: String,
    val moduleId: String,
    val learnerId: String,
    val moduleType: String,
    val activity_date: Date,
    val activity_start: Time,
    val activity_end: Time,
    val completed: Boolean,
    val score: Float
)

@Service
class ActivityService(val db: ActivityRepository) {
    fun findCourses() = db.findAll()

    fun addCourse(activity: Activity) = db.save(activity)

    fun updateCourse(id: String, activity: Activity) {
        if (db.existsById(id)) db.save(activity)
    }
    fun removeCourse(id: String) = db.deleteById(id)

    fun getCourseById(id: String) = db.findById(id)
}

@RestController
@RequestMapping("/activities")
class ActivityController(val service: ActivityService) {
    @GetMapping
    fun index() = service.findCourses()

    @PostMapping
    fun post(@RequestBody activity: Activity) = service.addCourse(activity)

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody activity: Activity) = service.updateCourse(id, activity)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = service.removeCourse(id)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String) = service.getCourseById(id)
}








