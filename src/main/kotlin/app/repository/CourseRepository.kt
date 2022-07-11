package app.repository

import app.model.Course
import org.springframework.data.repository.PagingAndSortingRepository

interface CourseRepository : PagingAndSortingRepository<Course, String>