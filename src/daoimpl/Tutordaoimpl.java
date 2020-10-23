package daoimpl;

import java.io.EOFException;
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
import dao.Tutor;

public class Tutordaoimpl implements Tutor {

	
	
	/*Login() method allows tutor to login
	 * 
	 */
	public void Login() {
		Driver d1 = new Driver();

		Scanner s = new Scanner(System.in);

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		System.out.println("Welcome To Tutor Login page");
		System.out.println("Enter Username");
		String userName = s.next();
		d1.setTutorName(userName);

		System.out.println("Enter password");
		String password = s.next();
		d1.setTutorPwd(password);

		AdminDaoimpl ad = new AdminDaoimpl();

		{

			try {
				fis = new FileInputStream("Tutor.ser");
				ois = new ObjectInputStream(fis);

				while (true)
					try {

						Driver dr = (Driver) ois.readObject();

						if (dr.getTutorEmail().equals(userName)
								&& dr.getTutorName().equals(password)) {
							System.out.println("Login Successfully ");
							System.out.println("Welcome to Tutor Homepage");
							System.out
									.println("1.View My Details\n2.View Student Details\n3.Logout");
							System.out.println("Enter your choice");
							int ch = s.nextInt();

							switch (ch) {
							case 1:
								System.out.println(dr);

								break;
							case 2:
								Tutordaoimpl td = new Tutordaoimpl();
								td.DetailsStudent();

								break;
							case 3:
								System.out.println("Logout Successfully");
								System.out
										.println("If you want to login again ");
								DrivingSchool ds = new DrivingSchool();
								ds.mainMenu();
								break;
							default:
								System.out.println("***Invalid choice***");
							}

						} else
							System.err.println("***Invalid Credentials***");

					}

					catch (EOFException e) {

					}
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}

			System.out.println("Do you want to continue  press 1.continue\n2.exit");
		}
	}

	/*DetailsStudent()method allows tutor to view student details from file student.ser
	 *  
	 */
	public void DetailsStudent() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("Student.ser");
			ois = new ObjectInputStream(fis);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			System.out.println(ois.readObject());
		} catch (ClassNotFoundException | IOException e) {

			e.printStackTrace();
		}

	}
}
