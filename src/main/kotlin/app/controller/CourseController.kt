package app.controller

import app.model.Course
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/courses/api")
class CourseController(val service: CourseService) {
    @GetMapping("/all")
    fun index() = service.findCourses()
    @GetMapping("/course")
    fun getById(@RequestParam id: String) = service.getCourseById(id)

    @PostMapping("/one")
    fun post(@RequestBody course: Course) = service.addCourse(course)
    @PostMapping("/many")
    fun postAll(@RequestBody courses: List<Course>) =service.addAllCourses(courses)

    @PutMapping("/course")
    fun update(@RequestParam id: String, @RequestBody course: Course) = service.updateCourse(id, course)

    @DeleteMapping("/course")
    fun delete(@RequestParam id: String) = service.removeCourse(id)


}
