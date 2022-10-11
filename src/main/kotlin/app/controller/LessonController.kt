package app.controller

import app.model.Lesson
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/lessons")
class LessonController(val service: LessonService) {

    @GetMapping("/all")
    fun index() = service.findAllLessons()


    @GetMapping("/all", params = ["sortBy"])
    fun sortedIndex(
        @RequestParam sortBy: String
    ) = service.findAllSorted(sortBy)


    @GetMapping("/{id}")
    fun getById(@PathVariable id: String) = service.findLessonById(id)

    @PostMapping("/one")
    fun post(@RequestBody lesson: Lesson) = service.addLesson(lesson)

    @PostMapping("/many")
    fun postAll(@RequestBody lesson: List<Lesson>) = service.addLessons(lesson)

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody lesson: Lesson): Lesson = service.updateLesson(id, lesson)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = service.removeLesson(id)

}
