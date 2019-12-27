package com.example.demo.mapper;

import com.example.demo.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Seth
 * @Date: 2019/4/8 13:46
 * @Version 1.0
 */

@Mapper
public interface CourseMapper {

    void addCourse(Course course);/*添加课程*/
    Integer count(); /*查询表记录个数*/

    List<Course> showCourseMsg(Teacher teacher);/*根据教师名称查找该教师教授的课程*/
    Course toUpdate(Course course);/*根据课程id查询课程信息*/
    void updateCourseMsg(Course course);/*根据课程id更新课程信息*/
    void deleteCourseMsg(Course course);/*根据课程id删除该条记录*/

    List<SerchTeacherResult> showChooseCourse(SerchTeacher teacher);/*!!!!查找符合条件的老师-》日期和技术

    void chooseCourseStudentNumber(Course course);/*根据课程id更新课程选课人数*/
    void addChooseCourse(ChooseCourse chooseCourse);/*向选课信息表中插入记录*/
    Integer studentChooseMaxCourse(String studentNname);/*查询每名学生选了几门课*/
    List<TeacherSeeCourseList> chooseCourseList(String teacherName);/*查询选择该老师的课程信息*/
    List<adminSeeStudentChooseCourseMsg> adminSeeStudentChooseCourseMsg();/*管理员查看学生选课信息*/
    List<Course> showAllCourseMsg();/*查看所有课程信息*/
	SerchTeacherResult serchFee(SerchTeacherResult result1);
	void insertStudentApply(StudentApply apply);
	List<SerchCurrentResult> showCurrentResults(StudentName studentName);
	List<SerchCurrentResult> showCompleteResults(StudentName studentName);
	List<SerchCurrentResult> showMentorCurrentResults(StudentName studentName);
	List<SerchCurrentResult> showMentorCompleteResults(StudentName studentName);
	void addTec(Tec tec);
	List<Tec> showAllTec();
	void deleteTec(Tec tec);
	List<User> showAllUsers();
	void deleteUser(User user);
	void updateConfirm(SerchCurrentResult result);

}
