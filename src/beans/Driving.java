package beans;

import java.io.Serializable;

public class Driving implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String studentName;
	private long studentPhoneNumber;
	private String studentAddress;
	private String email;
	private String studentPwd;
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public long getStudentPhno() {
		return studentPhoneNumber;
	}
	public void setStudentPhno(long studentPhno) {
		this.studentPhoneNumber = studentPhno;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStudentPwd() {
		return studentPwd;
	}
	public void setStudentPwd(String studentPwd) {
		this.studentPwd = studentPwd;
	}
	@Override
	public String toString() {
		return studentName+"\t"+" "+studentPhoneNumber+"\t"+" "+studentAddress+"\t"+" "+email;
	}

	
	
	
	
}
