package app.controller

import app.model.Course
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/courses")
class CourseController(val service: CourseService) {


    @GetMapping("/all")
    fun index() = service.findAllCourses()

    //  get a random course
    @GetMapping("/random")
    fun getRandom() = service.findRandom()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String) = service.findCourseById(id)

    @GetMapping("/all", params = ["sortBy"])
    fun sortedIndex(
        @RequestParam sortBy: String
    ) = service.findAllSorted(sortBy)

    @PostMapping("/one")
    fun post(@RequestBody course: Course) = service.addCourse(course)

    @PostMapping("/many")
    fun postAll(@RequestBody courses: List<Course>) = service.addCourses(courses)


    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody course: Course): Course = service.updateCourse(id, course)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = service.removeCourse(id)
//




}
