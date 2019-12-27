package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Seth
 * @Date: 2019/4/8 13:49
 * @Version 1.0
 */

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseMapper courseMapper;

	@Override
	public void addCourse(Course course) {
		courseMapper.addCourse(course);
	}

	@Override
	public List<Tec> showAllTec() {
		return courseMapper.showAllTec();
	}

	@Override
	public List<User> showAllUsers() {
		
		return courseMapper.showAllUsers();
	}

	@Override
	public void updateConfirm(SerchCurrentResult result) {
		
		courseMapper.updateConfirm(result);
	}

	@Override
	public void deleteUser(User user) {
		
		courseMapper.deleteUser(user);
	}

	@Override
	public Integer count() {

		return courseMapper.count();
	}

	@Override
	public void deleteTec(Tec tec) {
		courseMapper.deleteTec(tec);
		
	}

	@Override
	public void addTec(Tec tec) {
		
		courseMapper.addTec(tec);
	}

	@Override
	public List<Course> showCourseMsg(Teacher teacher) {

		return courseMapper.showCourseMsg(teacher);
	}/* 根据教师名称查找该教师教授的课程 */

	@Override
	public Course toUpdate(Course course) {

		return courseMapper.toUpdate(course);
	}/* 根据课程id查询课程信息 */

	@Override
	public void updateCourseMsg(Course course) {

		courseMapper.updateCourseMsg(course);
	}/* 根据课程id更新课程信息 */

	@Override
	public void deleteCourseMsg(Course course) {

		courseMapper.deleteCourseMsg(course);
	}/* 根据课程id删除该条记录 */

	@Override
	public List<SerchTeacherResult> showChooseCourse(SerchTeacher teacher) {
		List<SerchTeacherResult> resultList = new ArrayList();
		resultList = courseMapper.showChooseCourse(teacher);
		for (int i = 0; i < resultList.size(); i++) {
			SerchTeacherResult result1 = resultList.get(i);
			result1.setTechnologies(teacher.getTechnologies());
			SerchTeacherResult result2 = courseMapper.serchFee(result1);
			result1.setFee(result2.getFee());
			resultList.set(i, result1);
		}
		return resultList;
	}

	@Override
	public void insertStudentApply(StudentApply apply) {
		
		courseMapper.insertStudentApply(apply);
		
	}

	@Override
	public List<SerchCurrentResult> showCurrentResults(StudentName studentName) {
		return courseMapper.showCurrentResults(studentName);
	}

	@Override
	public List<SerchCurrentResult> showCompleteResults(StudentName studentName) {
		return courseMapper.showCompleteResults(studentName);
	}

	@Override
	public List<SerchCurrentResult> showMentorCurrentResults(StudentName studentName) {
		return courseMapper.showMentorCurrentResults(studentName);
	}

	@Override
	public List<SerchCurrentResult> showMentorCompleteResults(StudentName studentName) {
		return courseMapper.showMentorCompleteResults(studentName);
	}
	
	/* 根据学生学院查找指定课程 */

	/*
	 * @Override public void addChooseCourse(ChooseCourse chooseCourse){
	 * 
	 * courseMapper.addChooseCourse(chooseCourse); }向选课信息表中插入记录
	 * 
	 * @Override public Integer studentChooseMaxCourse(String studentNname){
	 * 
	 * return courseMapper.studentChooseMaxCourse(studentNname); }查询每名学生选了几门课
	 * 
	 * @Override public List<TeacherSeeCourseList> chooseCourseList(String
	 * teacherName){
	 * 
	 * return courseMapper.chooseCourseList(teacherName); }查询选择该老师的课程信息
	 * 
	 * @Override public List<adminSeeStudentChooseCourseMsg>
	 * adminSeeStudentChooseCourseMsg(){
	 * 
	 * return courseMapper.adminSeeStudentChooseCourseMsg(); }管理员查看学生选课信息
	 * 
	 * @Override public List<Course> showAllCourseMsg(){
	 * 
	 * return courseMapper.showAllCourseMsg(); }查看所有课程信息
	 */
}
