package daoimpl;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.DrivingSchool;
import beans.Driver;
import beans.Driving;
import dao.Admin;

public class AdminDaoimpl {
	String username = "admin";
	String password = "admin";

	/*adminPage() method allows admin to  view student details,
	 *  tutor registration,
	 *   delete student details and 
	 *   view tutor details 
	 */
	

	public void adminPage() {
		System.out.println("***************************************************************************************");
		System.out.println("\t\t\tWelcome to Admin page");
		System.out.println("***************************************************************************************");

		AdminDaoimpl ad = new AdminDaoimpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User name:");
		String username = sc.next();
		System.out.println("Enter Password:");
		String givenpassword = sc.next();
		
		
		
		if (ad.username.equals(username) && ad.password.equals(givenpassword)) {
			System.out.println("Login Successfully");
			System.out.println("");
			int c = 1;
			while (c == 1) {

				System.out
						.println("1.View student details\n2.Register tutor\n3.Delete student details\n4.View tutor details");
				System.out.println("Enter your choice");
				int ch = sc.nextInt();
				switch (ch) {
				case 1:
					viewStudentDetails();
					break;
				case 2:
					registerTutor();
					break;
				case 3:
					deleteStudentDetails();
					break;
				case 4:
					viewTutor();
					break;
				default:
					System.out.println("***Invalid choice***");
					ch = sc.nextInt();
				}

				System.out
						.println("Do you want to continue press  \n1.Continue\n2.Logout");
				c = sc.nextInt();

			}DrivingSchool.mainMenu();

			
		} else {
			System.err.println("Enter valid UserName and Password");
		}

	}

	
	
	/*
	 *  viewStudentDetails()   allows admin to  view student details ***/
	 
	 
	public void viewStudentDetails() {

		System.out.println("Student name \tPhone number \tAddress \tEmail id");
		System.out
				.println("----------------------------------------------------------------------------------");
		try {
			FileInputStream fis = new FileInputStream("Student.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);

			while (true) {

				try {

					Driving d = (Driving) ois.readObject();
					System.out.println(d);

				
				}

				catch (Exception e) {
					break;
				}
			}
		} catch (Exception e) {
		}
	}

	
	
	 
	/*
	 * registerTutor()   allows admin to  add tutor details */ 
	 
	public static void registerTutor() {

		File f = null;
		File tempTutor = null;

		f = new File("Tutor.ser");
		tempTutor = new File("tempTutor.ser");

		if (f.exists()) {

			FileOutputStream fos = null;
			ObjectOutputStream oos = null;

			FileInputStream fis = null;
			ObjectInputStream ois = null;

			Scanner sc = new Scanner(System.in);
			int ch = 1;
			Driver d = null;

			try {
				fis = new FileInputStream(f);
				ois = new ObjectInputStream(fis);

				fos = new FileOutputStream(tempTutor);
				oos = new ObjectOutputStream(fos);

				while (true) {
					try

					{

						d = (Driver) ois.readObject();

						oos.writeObject(d);

					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (EOFException e) {

					}

					while (ch == 1) {
						d = new Driver();
						Scanner s = new Scanner(System.in);
						System.out.println("***************************************************************************************");
						System.out.println("\t\t\tWelcome to Tutor Registration");
						System.out.println("***************************************************************************************");
						System.out.println("Enter your name");
						String tutorName = s.next();
						while (!tutorName.matches("[A-z][a-z]*"))
						/*
						 * Here we are using this validation to allow user 
						 * to give the starting alphabet of a tutor name should be capital
						 */
						
						{
							System.err.println("***Enter Characters only***");
							tutorName = s.next();
						}

						d.setTutorName(tutorName);

						System.out.println("Enter mobile number");

						String mobileNumber = s.next();
						while (!mobileNumber.matches("^1?(\\d{10})"))
						/*
						 * Here we are using this validation to 
						 * allow user to give only 10 digits
						 */
												
						{
							System.err.println("Entered mobile number is not valid");
							System.err
									.println("***Please enter 10 digit number*** ");
							mobileNumber = s.next();

							System.out.println(mobileNumber);
						}
						long l = Long.parseLong(mobileNumber);

						d.setTutorphno(l);

						System.out.println("Enter your Email");
						String tutorEmail = s.next();

						d.setTutorEmail(tutorEmail);
						System.out.println("Select the packages");
						System.out.println("1.3000package\n2.4000package\n3.5000package");

						int pack = s.nextInt();
						if (pack == 1) {
							d.setPackageName("3000");
						} else if (pack == 2) {
							d.setPackageName("4000");
						} else if (pack == 3) {
							d.setPackageName("5000");
						} else {
							System.out.println("Wrong Choice");
						}

						System.out
								.println("Select Timings\n1.6:00am-7:30am\n2.7:30am-9:00am\n3.9:00am-10:30am\n4.4:00pm-5:30pm\n5.5:30pm-7:00pm");
						int time = sc.nextInt();

						if (time == 1) {
							d.setTimings("6:00am-7:30am");
						} else if (time == 2) {
							d.setTimings("7:30am-9:00am");
						} else if (time == 3) {
							d.setTimings("9:00am-10:30am");
						} else if (time == 4) {
							d.setTimings("4:00pm-5:30pm");
						} else if (time == 5) {
							d.setTimings("5:30pm-7:00pm");
						} else {
							System.out.println("Sorry wrong choice");
						}

						try {
							oos.writeObject(d);
						} catch (IOException e1) {

							e1.printStackTrace();
						}
						System.out.println("Registered Successfully");

						String userName = d.getTutorEmail();

						System.out.println("Your UserName:" + userName);

						String password = d.getTutorName();
						System.out.println("Your Password:" + password);
						System.out.println("Do you want to add one more tutor press 1.Continue\n2.logout");
						ch = s.nextInt();

						if (ch != 1) {
							f.delete();
							tempTutor.renameTo(f);

							break;

						}

					}System.out.println("Logout Successfully");
					DrivingSchool.mainMenu();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			try {
				f.createNewFile();
				tempTutor.createNewFile();
				add();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	/*
	 * add() method allows admin to add tutors
	 */
	public static void add() {

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream("Tutor.ser");
			oos = new ObjectOutputStream(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int ch = 1;
		Driver d = null;
		while (ch == 1) {
			Scanner s = new Scanner(System.in);
			System.out.println("******************************************************************************************");
			System.out.println("\t\t\tWelcome to Tutor Registration");
			System.out.println("******************************************************************************************");
			System.out.println("Enter your name");
			String tutorName = s.next();
			while (!tutorName.matches("[A-za-z]*")) {
				/*
				 * Here we are using this validation to allow user 
				 * to give the starting alphabet of a tutor name should be capital
				 */
				
				System.err.println("***Enter Characters only***");
				tutorName = s.next();
			}

			d.setTutorName(tutorName);

			System.out.println("Enter mobile number");

			String mobileNumber = s.next();
			while (!mobileNumber.matches("^1?(\\d{10})"))
				/*
				 * Here we are using this validation to 
				 * allow user to give only 10 digits
				 */
			{
				System.err.println("Entered MobileNumber is not valid");
				System.err.println("***Please enter 10 digit number*** ");
				mobileNumber = s.next();

				System.out.println(mobileNumber);
			}
			long l = Long.parseLong(mobileNumber);

			d.setTutorphno(l);

			System.out.println("Enter your Email");
			String tutorEmail = s.next();
			d.setTutorEmail(tutorEmail);
		}

		try {
			oos.writeObject(d);
		} catch (IOException e1) {

			e1.printStackTrace();
		}

	}
	
	
  /* 
   * viewTutor() method displays the registered tutor details from the file Tutor.ser  
   */

	public void viewTutor() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Tutor name\tPhone Number\t EmailID\tPackage\tTimings");
		System.out.println("----------------------------------------------------------------------");
		try {
			FileInputStream fis = new FileInputStream("Tutor.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);

			int ch = 1;
			while (ch == 1) {
				try {
					Driver dd = (Driver) ois.readObject();

					System.out.println(dd);
				} catch (ClassNotFoundException | EOFException e1) {
					break;
				} catch (IOException e) {

				}
				
				
			}

		}

		catch (Exception e) {

		}

	}
	
	
/*
 *deleteStudentDetails() method allows admin to delete student details
 * 
 */
	
	public void deleteStudentDetails() {
		
		Scanner sc = new Scanner(System.in);
		File f = null;
		File tempStudent = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		Driving d=null;
		List list=new ArrayList();

		int c=1;
		while(c==1){
		try {

			f = new File("Student.ser");
			tempStudent = new File("tempStudent.ser");

			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);

			fos = new FileOutputStream(tempStudent);
			oos = new ObjectOutputStream(fos);
		
			System.out.println("Enter Student Name to delete");
			
			String studentName = sc.next();

	
			while(( d = (Driving) ois.readObject())!=null){
			if(d.getStudentName().equalsIgnoreCase(studentName)){
				list.add(d);


			System.out.println("Are you sure you want to delete the student");
            System.out.println("1.yes 2.no");
            String ch=sc.next();
            switch(ch){
            case "1":
                break;
                
                
                
            case "2":AdminDaoimpl admin=new AdminDaoimpl();
            admin.adminPage();
            break;
            
            }
        }
        
        else
        {
            oos.writeObject(d);
  }
        

			}
   
} catch (EOFException e) {
    
	if(list.isEmpty())
    {
        System.out.println("Record not found");
    }
	else
    
        
        
        System.out.println("Student deleted");
    }
     catch (ClassNotFoundException e) {
    e.printStackTrace();
} catch(IOException e){
    e.printStackTrace();
}

f.delete();
tempStudent.renameTo(f);



System.out.println("Do you want to continue press 1 else press2");
c=sc.nextInt();
		}
}
}








