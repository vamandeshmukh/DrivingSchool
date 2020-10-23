package daoimpl;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import controller.DrivingSchool;
import beans.Driver;
import beans.Driving;
import dao.Student;

public class Studentdaoimpl implements Student {

	int i;

	
	/*studentRegister() methods allows student to register his details 
	 * */
	public void studentRegister() {

		File f = null;
		File tempStudent = null;

		f = new File("Student.ser");
		tempStudent = new File("tempStudent.ser");

		if (f.exists()) {

			FileOutputStream fos = null;
			ObjectOutputStream oos = null;

			FileInputStream fis = null;
			ObjectInputStream ois = null;

			Scanner s = new Scanner(System.in);
			int ch = 1;

			try {
				fis = new FileInputStream(f);
				ois = new ObjectInputStream(fis);

				fos = new FileOutputStream(tempStudent);
				oos = new ObjectOutputStream(fos);

				while (true) {
					try

					{

						Driving d = (Driving) ois.readObject();

						oos.writeObject(d);

					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (EOFException e) {

					}

				
						Driving d = new Driving();
						System.out.println("***************************************************************************");
						System.out.println("\t\tWelcome to Student Registration");
						System.out.println("***************************************************************************");
						System.out.println("Enter your name");
						String name = s.next();
						while (!name.matches("[A-Z][a-zA-Z]*")) {
							System.err.println("Enter characters only");
							name = s.next();
							
						}

						d.setStudentName(name);
						System.out.println("Enter mobile number");

						String mobileNumber = s.next();
						while (!mobileNumber.matches("^1?(\\d{10})")) {
							
							System.err.println("Entered mobilenumber is not valid");
							System.err.println("Please enter 10 digit number ");
							mobileNumber = s.next();

							System.out.println(mobileNumber);
						}
						long l = Long.parseLong(mobileNumber);

						d.setStudentPhno(l);

						System.out.println("Enter your Address");
						String address = s.next();
						d.setStudentAddress(address);

						System.out.println("Enter your Email");
						String mail = s.next();
						d.setEmail(mail);

						System.out.println("Enter your Password");
						String pwd = s.next();
						d.setStudentPwd(pwd);

						try {

							oos.writeObject(d);

						} catch (IOException e) {

						}
						System.out.println("Registered Successfully");

						
						System.out.println("Do you want to Confirm  registration press-> 2 ");
						ch = s.nextInt();
						Studentdaoimpl sd=new Studentdaoimpl();
						

						if (ch != 1) {

							f.delete();
							tempStudent.renameTo(f);

							sd.studentLogin();	
							break;

						}
						
					}
				
				} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			try {
				f.createNewFile();
				// temp.createNewFile();
				add();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*add() method allows to add students into file student.ser
	 * */
	public static void add() {

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		Scanner s = new Scanner(System.in);

		try {
			fos = new FileOutputStream("Student.ser");
			oos = new ObjectOutputStream(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int ch = 1;
		Driving d = null;

		while (ch == 1) {
			Driving d1 = new Driving();
			/*System.out.println("**************************************************************************************");
			System.out.println("\t\t\tWelcome to Student Registration");
			System.out.println("**************************************************************************************");*/
			System.out.println("Enter your name");
			String name = s.next();
			//System.out.println(name);
			while (!name.matches("[A-Z][a-zA-Z]*")) {
				System.err.println("Enter Characters only");
				name = s.next();

			}

			d1.setStudentName(name);

			System.out.println("Enter mobile number");

			String mobileNumber = s.next();
			while (!mobileNumber.matches("^1?(\\d{10})")) {
				System.err.println("Entered MobileNumber is not valid");
				System.err.println("Please enter 10 digit number ");
				mobileNumber = s.next();

			}
			long l = Long.parseLong(mobileNumber);

			d1.setStudentPhno(l);

			System.out.println("Enter your Address");
			String address = s.next();
			d1.setStudentAddress(address);

			System.out.println("Enter your Email");
			String mail = s.next();
			d1.setEmail(mail);

			System.out.println("Enter your Password");
			String pwd = s.next();
			d1.setStudentPwd(pwd);

			try {
				oos.writeObject(d1);

			} catch (IOException e) {

			}
		}

	}
	
	
/*get() method allow to get student details
 * 
 */
	public void get() {

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Driving dd = null;

		try {
			fis = new FileInputStream("Student.ser");
			ois = new ObjectInputStream(fis);

			while (true) {

				try {

					dd = (Driving) ois.readObject();
					System.out.println(dd);
				} catch (EOFException E) {

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
/*	
 * studentLogin() method allows the student to login , view details , view tutor details and session pacakages
 */
	
	public  void studentLogin() {

		Scanner s = new Scanner(System.in);

		FileInputStream fis = null;
		ObjectInputStream ois = null;

		System.out.println("Welcome to Student Login page");

		System.out.println("Enter Username");
		String userName = s.next();

		System.out.println("Enter pwd");
		String pswd = s.next();
		Driving dd = null;
		String fileEmail = "";
		String filePassword = "";
		try {
			fis = new FileInputStream("Student.ser");
			ois = new ObjectInputStream(fis);

			while (true) {

				try {

					dd = (Driving) ois.readObject();

					/*fileEmail = dd.getEmail();
					filePassword = dd.getStudentPwd();*/
			//		System.out.println(dd);

					if (dd.getEmail().equals(userName) && dd.getStudentPwd().equals(pswd)) {

						System.out.println("Login Successful\n");
						int c = 1;
						while (c == 1) {
							System.out.println("1.View My Details\n2.View Tutor Details\n3.Session Packages");
							System.out.println("Enter the choice");

							int ch = s.nextInt();

							switch (ch) {
							case 1:
								System.out.println("Your Name:"
										+ dd.getStudentName()
										+ "\nMobileNumber:"
										+ dd.getStudentPhno()+"\nEmailId:"
										+ dd.getEmail());
								break;
							case 2:
								AdminDaoimpl ad = new AdminDaoimpl();
								ad.viewTutor();

								break;
							case 3:
								SessionPackages sp = new SessionPackages();
								sp.displayPackages();

								break;
							default:
								System.out.println("***Invalid Choice***");
								ch=s.nextInt();
							}

						
							System.out.println("Do you want to continue \n1.Continue\n2.Logout");
							c = s.nextInt();
						}

					} 
					 /*else { System.out.println("***Invalid Credentials***");
					 break;
					 
					 }*/
					 
					

				} catch (EOFException e) {
					System.out.println("Logout Successfully");
					DrivingSchool.mainMenu();
				} catch (Exception e) {
					e.printStackTrace();
				}
		
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	
	/*editDetails() method allows student to edit his details
	 * 
	 */
	public void editDetails() {

		
		Scanner sc = new Scanner(System.in);
		
		File f = null;
		File tempStudent = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		f = new File("Student.ser");
		tempStudent = new File("tempStudent.ser");

		try {
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);

			fos = new FileOutputStream(tempStudent);
			oos = new ObjectOutputStream(fos);
			System.out.println("Enter the mobile number");
			long mobileNumber = sc.nextLong();

			Driving d = (Driving) ois.readObject();

			if (mobileNumber == d.getStudentPhno()) {

				System.out.println("Enter new address");
				String newAddress = sc.next();
				d.setStudentAddress(newAddress);
			} else {

			}

			oos.writeObject(d);

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

		}
		f.delete();
		tempStudent.renameTo(f);
		System.out.println("Details edited");

	}

}
