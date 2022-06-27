package app.controller

import app.model.Course
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/courses")
class CourseController(val service: CourseService) {
    @GetMapping
    fun index() = service.findCourses()

    @PostMapping
    fun post(@RequestBody course: Course) = service.addCourse(course)

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody course: Course) = service.updateCourse(id, course)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = service.removeCourse(id)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String) = service.getCourseById(id)
}
