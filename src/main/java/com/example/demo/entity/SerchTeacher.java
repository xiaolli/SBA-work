package com.example.demo.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


public class SerchTeacher {

	 private Date date;

	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  
    private String technologies;

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getTechnologies() {
			return technologies;
		}

		public void setTechnologies(String technologies) {
			this.technologies = technologies;
		}

   
}
