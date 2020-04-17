package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;

//操作数据库
//原子性的增，删，改，查（位于数据访问层）
public class StudentDao {
	
	private static final String URL="jdbc:mysql://localhost:3306/studentDatabase";
	private static final String USER="root";
	private static final String PASSWORD="admin";
	//要想增加，必须先判断是否已经存在
	public static boolean isExist(int sno){
		//如果等于null，说明不存在
		return StudentDao.queryStudentBySno(sno)==null? false:true;
	}
	
	
 	//增加方法
	public static boolean addStudent(Student student) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql="insert into student values(?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, student.getSno());
			pstmt.setString(2, student.getSname());
			pstmt.setInt(3, student.getSage());
			pstmt.setString(4, student.getSaddress());
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				return true;
			}
			return false;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
				try {
					if(pstmt!=null)pstmt.close();
					if(connection!=null)connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	//删除方法（根据sno进行）
	public static boolean deleteStudent(int sno) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql="delete from student where sno=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, sno);
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				return true;
			}
			return false;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
				try {
					if(pstmt!=null)pstmt.close();
					if(connection!=null)connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	//修改方法（根据sno 修改student）
	public static boolean updateStudent(int sno,Student student) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql="update student set sname=?,sage=?,saddress=? where sno=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, student.getSname());
			pstmt.setInt(2, student.getSage());
			pstmt.setString(3, student.getSaddress());
			pstmt.setInt(4, student.getSno());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				return true;
			}
			return false;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
				try {
					if(pstmt!=null)pstmt.close();
					if(connection!=null)connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	//查询方法
	public static Student queryStudentBySno(int sno) {
		Student student=null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql="select * from student where sno=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, sno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int no = rs.getInt("sno");
				String sname = rs.getString("sname");
				int sage = rs.getInt("sage");
				String saddress=rs.getString("saddress");
				student=new Student(no,sname,sage,saddress);
				return student;
			}
			return null;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(connection!=null)connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	//查询全部学生
	public static List<Student> queryAllStudent(){
		Student student=null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Student> students=new ArrayList<Student>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql="select * from student";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int sno = rs.getInt("sno");
				String sname = rs.getString("sname");
				int sage = rs.getInt("sage");
				String saddress=rs.getString("saddress");
				
				student=new Student(sno,sname,sage,saddress);
				students.add(student);
			}
			return students;
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(connection!=null)connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
}





