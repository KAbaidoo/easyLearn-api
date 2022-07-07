package app.controller

import app.model.Course
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/courses/api")
class CourseController(val service: CourseService) {


    @GetMapping("/all")
    fun index() = service.findCourses()

//  get a random course
    @GetMapping("/random")
    fun getRandom() = service.findRandom()

    @PostMapping("/one")
    fun post(@RequestBody course: Course) = service.addCourse(course)
    @PostMapping("/many")
    fun postAll(@RequestBody courses: List<Course>) =service.addAllCourses(courses)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String) = service.findCourseById(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody course: Course) = service.updateCourse(id, course)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = service.removeCourse(id)


}
