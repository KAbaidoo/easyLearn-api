package app.repository

import app.model.Course
import org.springframework.data.repository.CrudRepository

interface CourseRepository : CrudRepository<Course, String>