package com.service;

import java.util.List;

import com.dao.StudentDao;
import com.entity.Student;

//业务逻辑层，对原子性增删改查进行组装
public class StudentService {
	//进行组装，需要有对应方法
	
	//增加方法
	public boolean addStudent(Student student) {
		if(!StudentDao.isExist(student.getSno())) {
			return StudentDao.addStudent(student);
		}
		return false;
	}
	//删除方法
	public boolean deleteStudent(int sno) {
		if(StudentDao.isExist(sno)) {
			return StudentDao.deleteStudent(sno);
		}
		return false;
	}
	//修改方法
	public boolean updateStudent(int sno,Student student) {
		if(StudentDao.isExist(student.getSno())) {
			return StudentDao.updateStudent(sno,student);
		}
		return false;
	}
	
	
	//根据sno查询学生详细信息
	public Student queryStudentBySno(int sno) {
		return StudentDao.queryStudentBySno(sno);
	}
	
	
	//查询全部信息
	public List<Student> queryAllStudent() {
		return StudentDao.queryAllStudent();
	}
	
	
}
