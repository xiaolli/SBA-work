package com.example.demo.entity;


public class ChooseCourse {

    private String studentName;
    private Integer courseId;
    private String updatetime;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "ChooseCourse{" +
                "studentName='" + studentName + '\'' +
                ", courseId=" + courseId +
                ", updatetime='" + updatetime + '\'' +
                '}';
    }
}
