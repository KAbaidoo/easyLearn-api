package app.controller

import app.model.Lesson
import app.repository.LessonRepository
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class LessonService(val db: LessonRepository) {

    fun findAllLessons() = db.findAll()

    fun addLesson(lesson: Lesson): Lesson = db.save(lesson)

    fun updateLesson(id: String, payload: Lesson): Lesson {
        return if (db.existsById(id)) {
            db.deleteById(id)
            db.save(
                Lesson(
                    id = payload.id,
                    title = payload.title,
                    courseId = payload.courseId,
                    src = payload.src,
                    duration = payload.duration,
                    lesson = payload.lesson,

                    )
            )

        } else throw ResponseStatusException(HttpStatus.NOT_FOUND, "The id: $id does not exist")

    }

    fun removeLesson(id: String) = db.deleteById(id)

    fun findLessonById(id: String) = db.findById(id)

    fun addLessons(lessons: List<Lesson>) = db.saveAll(lessons)

//    get lessons sorted by number

    fun findAllSorted(property: String): MutableIterable<Lesson> {
        val sort: Sort = Sort.by(Sort.Direction.DESC, property)
        return db.findAll(sort)
    }

    fun findByCourseId(courseId: String): MutableIterable<Lesson> {
        return db.findLessonsByCourseId(courseId)
    }

    fun updateCourseIdForLessons(oldId: String, newId: String): MutableIterable<Lesson> {
        db.findLessonsByCourseId(oldId).forEach {
            it.id?.let { id -> db.deleteById(id) }
            db.save(
                Lesson(
                    id = null,
                    title = it.title,
                    courseId = newId,
                    src = it.src,
                    duration = it.duration,
                    lesson = it.lesson,
                )
            )

        }
        return db.findLessonsByCourseId(newId)

    }


}