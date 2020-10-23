package controller;


import java.util.Scanner;

import daoimpl.AdminDaoimpl;
import daoimpl.Studentdaoimpl;
import daoimpl.AdminDaoimpl;
import daoimpl.Tutordaoimpl;
public class DrivingSchool {


	public static void main(String[] args) {

		DrivingSchool ds=new DrivingSchool();
		ds.mainMenu();

	}

	/*
	 * mainMenu() method displays the home page of motor driving school
	 * */
	
	static public void mainMenu(){
		int c=1;
	
			System.out.println("************************************************************************************");
			System.out.println("\t\t\tWELCOME TO MOTOR DRIVING SCHOOL");
			System.out.println("************************************************************************************");
			Scanner sc=new Scanner(System.in);
			System.out.println("Home Page");
			System.out.println("1.Admin\n2.Student\n3.Tutor");
			System.out.println("Enter Your Choice");

			int choice=sc.nextInt();

			switch(choice)
			{
			case 1: admin();
			break;
			case 2: student();
			break;
			case 3: tutor();
			break;
			default: System.out.println("Invalid Choice");
			break;
			}
		
	}                                                                                                                                                

/*admin() method validates the admin to view student detail, tutor registration, delete student details and view tutor details 
 * */
	public static void admin(){
		AdminDaoimpl ad=new AdminDaoimpl();
		ad.adminPage();
	}

	
	/*student() method allows student to register ,login and edit
	 * */
	public static void student()

	{int c=1;
	
		System.out.println("1.Register\n2.Login\n3.Edit details");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your choice");
		Studentdaoimpl sd=new Studentdaoimpl();
		int ch=sc.nextInt();

		switch(ch)
		{
		case 1:sd.studentRegister();
		break;
		case 2:sd.studentLogin();
		break;
		case 3:sd.editDetails();
		break;
		default :System.out.println("Wrong choice");

		}
	}

	

	/*tutor() method allows tutor to login
	 * */
	public 	static void tutor(){
		System.out.println("1.Login\n2Exit");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your choice");
		int ch=sc.nextInt();
		Tutordaoimpl ti=new Tutordaoimpl();
		int c=1;

		switch(ch)
		{
		case 1:ti.Login();
		break;
		case 2:System.out.println("Exit");
		break;
		default:System.out.println("Invalid Choice");
		}


	}


}
