package beans;

import java.io.Serializable;

public class Driver implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 8839246609359984548L;
	private String tutorName;
	private long tutorPhoneNumber;
	private String tutorEmail;
	private String tutorPwd;
	private String packageName;
	private String timings;
	public String getTutorName() {
		return tutorName;
	}
	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}
	public long getTutorphno() {
		return tutorPhoneNumber;
	}
	public void setTutorphno(long tutorphno) {
		this.tutorPhoneNumber = tutorphno;
	}
	
	public String getTutorEmail() {
		return tutorEmail;
	}
	public void setTutorEmail(String tutorEmail) {
		this.tutorEmail = tutorEmail;
	}
	public String getTutorPwd() {
		return tutorPwd;
	}
	public void setTutorPwd(String tutorPwd) {
		this.tutorPwd = tutorPwd;
	}
	
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}
	@Override
	public String toString() {
		return  tutorName+"\t "+tutorPhoneNumber+"\t "+tutorEmail+"\t "+packageName+"\t "+timings;
	}
	
	
	
}
