package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.CourseService;
import com.example.demo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Seth
 * @Date: 2019/4/8 13:50
 * @Version 1.0
 */

@RestController
@RequestMapping("course")
public class CourseController {

	@Autowired
	CourseService courseService;

	/* 添加课程信息 */
	@PostMapping("/addCourseMsg")
	public Response addCourse(@RequestBody Course course) {

		Response response = new Response();

		try {
			courseService.addCourse(course);
		} catch (Exception e) {
			response.setData(e);
			System.out.println(e);
			return response;
		}
		response.setStatus(200);
		return response;
	}
	
	@PostMapping("/addTec")
	public Response addTec(@RequestBody Tec tec) {

		Response response = new Response();

		try {
			courseService.addTec(tec);
		} catch (Exception e) {
			response.setData(e);
			System.out.println(e);
			return response;
		}
		response.setStatus(200);
		return response;
	}

	/* 统计课程表中有几条记录，用来给courseId赋值 */
	@PostMapping("/count")
	public Response countMsg() {

		Response response = new Response();
		Integer count = null;

		try {
			count = courseService.count();
		} catch (Exception e) {
			response.setData(e);
			return response;
		}
		if (count == null) {
			count = 1;
			response.setMessage("第一条记录");
			response.setStatus(count);
			return response;
		}
		response.setStatus(count);
		response.setMessage("记录信息");
		return response;
	}

	
	@PostMapping("/deleteTec")
	public Response deleteTec(@RequestBody Tec tec) {

		Response response = new Response();
		

		try {
			 courseService.deleteTec(tec);
		} catch (Exception e) {
			response.setData(e);
			return response;
		}
		
		response.setStatus(200);
		
		return response;
	}

	@PostMapping("/deleteUser")
	public Response deleteUser(@RequestBody User user) {

		Response response = new Response();
		

		try {
			 courseService.deleteUser(user);
		} catch (Exception e) {
			response.setData(e);
			return response;
		}
		
		response.setStatus(200);
		
		return response;
	}
	
	
	@PostMapping("/showCourseMsg")
	public Response showCourseMsg(@RequestBody Teacher teacher) {

		Response response = new Response();
		List<Course> course = null;
		try {
			course = courseService.showCourseMsg(teacher);
			System.out.println(course);
		} catch (Exception e) {

			response.setMessage("服务器异常");
			System.out.println(e);
			return response;
		}
		if (course.size() == 0) {
			response.setMessage("没有课程");
			return response;
		}
		response.setData(course);
		response.setStatus(200);
		return response;
	}

	@PostMapping("/showAllTec")
	public Response showAllTec() {

		Response response = new Response();
		List<Tec> tec = null;
		try {
			tec = courseService.showAllTec();
			
		} catch (Exception e) {

			response.setMessage("服务器异常");
			System.out.println(e);
			return response;
		}
		if (tec.size() == 0) {
			response.setMessage("no tecnologies");
			return response;
		}
		response.setData(tec);
		response.setStatus(200);
		return response;
	}

	@PostMapping("/showAllUsers")
	public Response showAllUsers() {

		Response response = new Response();
		List<User> user = null;
		try {
			user = courseService.showAllUsers();
			
		} catch (Exception e) {

			response.setMessage("服务器异常");
			System.out.println(e);
			return response;
		}
		if (user.size() == 0) {
			response.setMessage("no users");
			return response;
		}
		response.setData(user);
		response.setStatus(200);
		return response;
	}
	
	/* 根据课程id查询课程信息 */
	@PostMapping("/toUpdate")
	public Response toUpdate(@RequestBody Course course) {

		Response response = new Response();
		Course course1 = null;
		try {
			course1 = courseService.toUpdate(course);
		} catch (Exception e) {
			response.setMessage("sql语句出错");
			return response;
		}
		if (course1.getMaxStudentNumber() == course1.getStudentNumber()) {
			response.setMessage("选课人数已满");
		}
		response.setData(course1);
		response.setStatus(200);
		return response;
	}

	/* 根据课程id更新课程信息 */
	@PostMapping("/updateCourseMsg")
	public Response updateCourseMsg(@RequestBody Course course) {

		Response response = new Response();
		try {
			courseService.updateCourseMsg(course);
		} catch (Exception e) {
			response.setMessage("sql语句错误");
		}
		response.setMessage("更新成功");
		response.setStatus(200);
		return response;
	}

	/* 根据课程id删除该条表记录 */
	@PostMapping("deleteCourseMsg")
	public Response deleteCourseMsg(@RequestBody Course course) {

		Response response = new Response();
		try {
			courseService.deleteCourseMsg(course);
		} catch (Exception e) {
			System.out.println(e);
			response.setMessage("sql语句错误");
			return response;
		}
		response.setStatus(200);
		return response;
	}
	
	@PostMapping("confirmApply")
	public Response confirmApply(@RequestBody SerchCurrentResult result) {

		Response response = new Response();
		try {
			courseService.updateConfirm(result);
		} catch (Exception e) {
			System.out.println(e);
			response.setMessage("sql语句错误");
			return response;
		}
		response.setStatus(200);
		return response;
	}

	
	@PostMapping("/showChooseCourse")
	public Response showChooseCourse(@RequestBody SerchTeacher techer) {

		Response response = new Response();
		List<SerchTeacherResult> serchTeacherResults = null;
		try {
			serchTeacherResults = courseService.showChooseCourse(techer);
		} catch (Exception e) {
			System.out.println(e);
			response.setMessage("sql语句出错");
			return response;
		}
		if (serchTeacherResults.size() == 0) {
			response.setMessage("无符合条件课程");
			return response;
		}
		response.setData(serchTeacherResults);
		response.setStatus(200);
		return response;
	}

	@PostMapping("/currentTraining")
	public Response currentTraining(@RequestBody StudentName studentName) {

		Response response = new Response();
		List<SerchCurrentResult> serchCurrentResults = null;
		try {
			serchCurrentResults = courseService.showCurrentResults(studentName);
		} catch (Exception e) {
			System.out.println(e);
			response.setMessage("sql语句出错");
			return response;
		}
		if (serchCurrentResults.size() == 0) {
			response.setMessage("无符合条件课程");
			return response;
		}
		response.setData(serchCurrentResults);
		response.setStatus(200);
		return response;
	}
	
	@PostMapping("/mentorCompleteTraining")
	public Response mentorCompleteTraining(@RequestBody StudentName studentName) {

		Response response = new Response();
		List<SerchCurrentResult> serchCurrentResults = null;
		try {
			serchCurrentResults = courseService.showMentorCompleteResults(studentName);
		} catch (Exception e) {
			System.out.println(e);
			response.setMessage("sql语句出错");
			return response;
		}
		if (serchCurrentResults.size() == 0) {
			response.setMessage("无符合条件课程");
			return response;
		}
		response.setData(serchCurrentResults);
		response.setStatus(200);
		return response;
	}
	
	@PostMapping("/mentorCurrentTraining")
	public Response mentorCurrentTraining(@RequestBody StudentName studentName) {

		Response response = new Response();
		List<SerchCurrentResult> serchCurrentResults = null;
		try {
			serchCurrentResults = courseService.showMentorCurrentResults(studentName);
		} catch (Exception e) {
			System.out.println(e);
			response.setMessage("sql语句出错");
			return response;
		}
		if (serchCurrentResults.size() == 0) {
			response.setMessage("无符合条件课程");
			return response;
		}
		response.setData(serchCurrentResults);
		response.setStatus(200);
		return response;
	}
	
	@PostMapping("/completeTraining")
	public Response completeTraining(@RequestBody StudentName studentName) {

		Response response = new Response();
		List<SerchCurrentResult> serchCurrentResults = null;
		try {
			serchCurrentResults = courseService.showCompleteResults(studentName);
		} catch (Exception e) {
			System.out.println(e);
			response.setMessage("sql语句出错");
			return response;
		}
		if (serchCurrentResults.size() == 0) {
			response.setMessage("无符合条件课程");
			return response;
		}
		response.setData(serchCurrentResults);
		response.setStatus(200);
		return response;
	}
	
	
	@PostMapping("/studentApply")
	public Response studentApply(@RequestBody StudentApply apply) {

		Response response = new Response();
		
		try {
			 courseService.insertStudentApply(apply);
		} catch (Exception e) {
			System.out.println(e);
			response.setMessage("sql语句出错");
			return response;
		}
		
		
		response.setStatus(200);
		return response;
	}
	
	/* 根据课程id更新课程选课人数 */
	/*
	 * @PostMapping("/chooseCourseStudentNumber") public Response
	 * chooseCourseStudentNumber(@RequestBody Course course){
	 * 
	 * Response response = new Response();
	 * 
	 * try{ courseService.chooseCourseStudentNumber(course); }catch (Exception e){
	 * System.out.println(e); response.setMessage("sql语句出错"); return response; }
	 * response.setStatus(200); response.setMessage("选课成功"); return response; }
	 * 
	 * 添加选课记录
	 * 
	 * @PostMapping("/addChooseCourse") public Response addChooseCourse(@RequestBody
	 * ChooseCourse chooseCourse){
	 * 
	 * Response response = new Response(); try{
	 * courseService.addChooseCourse(chooseCourse); }catch (Exception e){
	 * System.out.println(e); response.setMessage("sql语句出错"); return response; }
	 * response.setStatus(200); return response; }
	 * 
	 * 查询学生选了几门课，每名学生最多可选5门课
	 * 
	 * @PostMapping("/studentChooseMaxCourse") public Response
	 * studentChooseMaxCourse(String studentName){
	 * 
	 * Response response = new Response(); Integer countID = null; try{ countID =
	 * courseService.studentChooseMaxCourse(studentName); }catch (Exception e){
	 * System.out.println(e); response.setMessage("sql语句错误"); return response; }
	 * 
	 * response.setStatus(countID); response.setMessage("可以选课"); return response; }
	 * 
	 * 根据老师姓名，查看选择该老师的学生列表
	 * 
	 * @PostMapping("/chooseCourseList") public Response chooseCourseList(String
	 * teacherName){
	 * 
	 * Response response = new Response(); List<TeacherSeeCourseList>
	 * teacherSeeCourseList = null; try{ teacherSeeCourseList =
	 * courseService.chooseCourseList(teacherName); }catch (Exception e){
	 * System.out.println(e); } if (teacherSeeCourseList == null){
	 * response.setStatus(100); response.setMessage("没有学生"); return response; }
	 * response.setStatus(200); response.setData(teacherSeeCourseList); return
	 * response; }
	 * 
	 * 管理员查看所有学生选课信息
	 * 
	 * @PostMapping("/adminSeeStudentChooseCourseMsg") public Response
	 * adminSeeStudentChooseCourseMsg(){
	 * 
	 * Response response = new Response(); List<adminSeeStudentChooseCourseMsg>
	 * adminSeeStudentChooseCourseMsg=null; try { adminSeeStudentChooseCourseMsg =
	 * courseService.adminSeeStudentChooseCourseMsg(); }catch (Exception e){
	 * System.out.println(e); response.setMessage("服务器错误，请联系管理员"); return response;
	 * } response.setData(adminSeeStudentChooseCourseMsg); response.setStatus(200);
	 * response.setMessage("查询成功"); return response; }
	 * 
	 * 显示所有课程信息
	 * 
	 * @PostMapping("/showAllCourseMsg") public Response showAllCourseMsg(){
	 * 
	 * Response response = new Response(); List<Course> courseList = null; try {
	 * courseList = courseService.showAllCourseMsg(); }catch (Exception e){
	 * System.out.println(e); response.setMessage("服务器错误，请联系管理员"); return response;
	 * } response.setData(courseList); response.setStatus(200);
	 * response.setMessage("查询成功"); return response; }
	 */

}
