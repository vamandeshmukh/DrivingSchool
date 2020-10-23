package daoimpl;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import beans.Driver;

public class SessionPackages {
	/*
	 * displayPackages() method displays the sessions packages to students
	 * 
	 */
	
	public  void displayPackages(){

		Scanner sc=new Scanner(System.in);
		System.out.println("SessionPackages and Details");
		System.out.println("Enter your choice");
		System.out.println("1.get5000PackageDetails\n2.get4000PackageDetails\n3.get3000PackageDetails");
		int ch=sc.nextInt();
		switch(ch){
		case 1:get5000PackageDetails();
		break;
		case 2:get4000PackageDetails();
		break;
		case 3:get3000PackageDetails();
		break;
		default :System.out.println("Invalid Choice");
		}
	}



	public static void get5000PackageDetails()
	{

		try {
			FileInputStream	fis = new FileInputStream("Tutor.ser");
			ObjectInputStream ois= new ObjectInputStream(fis);

			Driver driver=null;
			while( (driver=(Driver)ois.readObject())!=null)

			{

				if(driver.getPackageName().equals("5000"))
				{
					System.out.println("--------------------");
					System.out.println("Assigned Tutor");
				System.out.println("--------------------");
					System.out.print("TutorName :");
					System.out.println(driver.getTutorName());
					System.out.print("TutorPhonenumber :");
					System.out.println(driver.getTutorphno());
					System.out.print("Timings :");
					System.out.println(driver.getTimings());
				}

			}

		} catch (FileNotFoundException e) {


		} catch (EOFException  e) {


		} catch (ClassNotFoundException e) {


		}catch(IOException e){

		}

		Scanner s=new Scanner(System.in);
		System.out.println("Do you want to apply then enter 1");
		int apply=s.nextInt();
		System.out.println("Proceed for Creditcard Payment");
		System.out.println("Enter your creditcard number");
		String creditcardNumber=s.next();
		while(!creditcardNumber.matches("^1?(\\d{16})"))
			/*
			 * Here we are using this validation to 
			 * allow user to give only 16 digits
			 */
		
		{
			System.err.println("Entered creditcard number is not valid");
			System.err.println("Enter 16 digit number");
			creditcardNumber=s.next();
		}
		
		long number=Long.parseLong(creditcardNumber);
		
		
		
		
		System.out.println("Pay the Amount");

		double cash=s.nextDouble();
		int ch=1;
		while(ch==1){

			if(cash!=5000)
			{
				System.err.println("Please pay Rs.5000");
				cash=s.nextDouble();
				ch=1;
			}else{
				System.out.println("ThankYou for applying ");
				System.out.println("Your slot is Booked");
				ch=2;
			}
		}
	}



	public static void get4000PackageDetails(){

		try {
			FileInputStream	fis = new FileInputStream("Tutor.ser");
			ObjectInputStream ois= new ObjectInputStream(fis);

			Driver driver=null;
			while( (driver=(Driver)ois.readObject())!=null)

			{

				if(driver.getPackageName().equals("4000"))
				{System.out.println("--------------------");
					System.out.println("Assigned Tutor");
				System.out.println("--------------------");
					System.out.print("TutorName :");
					System.out.println(driver.getTutorName());
					System.out.print("TutorPhonenumber :");
					System.out.println(driver.getTutorphno());
					System.out.print("Timings :");
					System.out.println(driver.getTimings());
				}

			}

		} catch (FileNotFoundException e) {


		} catch (EOFException  e) {


		} catch (ClassNotFoundException e) {


		}catch(IOException e){

		}

		Scanner s=new Scanner(System.in);
		System.out.println("Do you want to Apply then enter 1");
		int apply=s.nextInt();
		System.out.println("Proceed for Creditcard Payment");
		System.out.println("Enter your creditcard number");
		
		
		String creditcardNumber=s.next();
		while(!creditcardNumber.matches("^1?(\\d{16})")){
			System.err.println("Entered creditcard number is not valid");
			System.err.println("Enter 16 digit number");
			creditcardNumber=s.next();
		}
		
		long number=Long.parseLong(creditcardNumber);
		
		
		System.out.println("Please pay Rs.4000");
		double cash=s.nextDouble();
		int ch=1;
		while(ch==1){
			if(cash!=4000)
			{
				System.err.println("Please pay Rs.4000");
				cash=s.nextDouble();
				ch=1;
			}
			else{
				System.out.println("ThankYou for applying ");
				System.out.println("Your slot is Booked");
				
				ch=2;
			}
			
		}
	}

	
	
	public static void get3000PackageDetails(){

		try {
			FileInputStream	fis = new FileInputStream("Tutor.ser");
			ObjectInputStream ois= new ObjectInputStream(fis);

			Driver driver=null;
			while( (driver=(Driver)ois.readObject())!=null)

			{

				if(driver.getPackageName().equals("3000"))
				{System.out.println("--------------------");
					System.out.println("Assigned Tutor");
				System.out.println("--------------------");
				System.out.print("TutorName :");
				System.out.println(driver.getTutorName());
				System.out.print("TutorPhonenumber :");
				System.out.println(driver.getTutorphno());
				System.out.print("Timings :");
				System.out.println(driver.getTimings());
				}

			}

		} catch (FileNotFoundException e) {


		} catch (EOFException  e) {


		} catch (ClassNotFoundException e) {


		}catch(IOException e){

		}

		Scanner s=new Scanner(System.in);
		System.out.println("Do you want to Apply then enter 1");
		int apply=s.nextInt();
		System.out.println("Proceed for Creditcard Payment");
		System.out.println("Enter your creditcard number");
		String creditcardNumber=s.next();
		while(!creditcardNumber.matches("^1?(\\d{16})")){
			System.err.println("Entered creditcard number is not valid");
			System.err.println("Enter 16 digit number");
			creditcardNumber=s.next();
		}
		
		long number=Long.parseLong(creditcardNumber);
		
		System.out.println("Please pay Rs.3000");
		double cash=s.nextDouble();
		int ch=1;
		while(ch==1){
			if(cash!=3000)
			{
				System.err.println("Please pay Rs.3000");
				cash=s.nextDouble();
				ch=1;
			}else{
				System.out.println("ThankYou for applying ");
				System.out.println("Your slot is Booked");
				ch=2;
			}


		}

	}

}


