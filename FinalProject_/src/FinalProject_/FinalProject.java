

// Import Necessary Packages/Libraries
package src.FinalProject_; 
import java.io.File;
import java.lang.Math;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;



// Main Function
public class FinalProject{
	public static void main(String[] args) throws Exception{
		
		ArrayList<Person> pList = new ArrayList<>(); 
		
		System.out.println("\tWelcome to my Personal Management Program");
		
		// Variable Initialization
		Scanner myScanner = new Scanner(System.in);
		String id = "";
		String fullName = "";
		String department = ""; 
		String Rank = "1";
		int creditHours = 0;; 
		double GPA = 0;;
		int choice = 0;;
		
		System.out.println(" ");
		System.out.println("Choose one of the options: ");
		System.out.println(" ");
		
		while(true){
				System.out.println("1-Enter the information of a faculty");
				System.out.println("2-Enter the information of a student");
				System.out.println("3-Print the tuition invoice for a Student");
				System.out.println("4-Print faculty information");
				System.out.println("5-Enter the information of a staff member"); 
				System.out.println("6-Print the information of a staff member"); 
				System.out.println("7-Delete a person"); 
				System.out.println("8-Exit Program");
			
			do {
				System.out.println(" ");
				System.out.print("\tEnter your selection: ");
				
				try {
					choice = myScanner.nextInt();
			
					switch(choice) {
			
				// Faculty Information
				case 1:
					System.out.println(" ");
					myScanner.nextLine();
					System.out.println("Enter the faculty's information");	
					do {
						System.out.print("Name of faculty: ");
						
						// Error handling for name information
						try {
							fullName = myScanner.nextLine();
							char[] array = fullName.toCharArray();
							for(char c: array) {
								if(!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')){ 
									System.out.println(" ");
									System.out.println("Please only enter names without digits"); 
									System.out.println(" ");
									System.out.print("Name of Student: ");
									fullName = myScanner.nextLine();
								}
							}
						}catch(InputMismatchException e) {
							myScanner.next();
							System.out.println("Sorry, the entered Name is invalid!");
						}
					}while(!(fullName.isEmpty() == false)); 
					
					while(true) {
						System.out.print("ID: ");
						id = myScanner.nextLine();
						if(id.matches("^[A-z]{2}[0-9]{4}$")) {
							boolean dupe = false;
							for(Person person: pList) {
								if(person.getId().equals(id)) {
								dupe = true;
								break;
							}
						}
						if(!dupe) {
							break;
						}
						
						// Error Handling
						else { 
							System.out.println(" ");
							System.out.println("Id already exists. please input a unique id");
							System.out.println(" ");
							}
						}else {
							System.out.println(" ");
							System.out.println("Invalid id format. must be LetterLetterDigitDigitDigitDigit");
							System.out.println(" ");
							}
					}
					System.out.print("Rank: ");
					Rank = myScanner.nextLine();
					
					// Error Handling
					while(!(Rank.equalsIgnoreCase("Professor") || Rank.equalsIgnoreCase("Adjunct"))) {
						System.out.println(" ");
						System.out.println("Sorry, entered Rank ("+Rank+") is invalid...Please select Professor or Adjunct");
						System.out.println(" ");
						System.out.print("Rank: ");
						Rank = myScanner.nextLine();
					}
					
					System.out.print("Department: ");
					department = myScanner.nextLine();
					
					// Error Handling
					while(!(department.equalsIgnoreCase("Mathematics")|| department.equalsIgnoreCase("English")||department.equalsIgnoreCase("Engineering"))){
						System.out.println(" ");
						System.out.println("Sorry, entered department ("+department+") is invalid...Please select Mathematics, English, or Engineering");
						System.out.println(" ");
						System.out.print("Department: ");
						department = myScanner.nextLine();
					}
					
					// Add a new faculty member based on user's input
					Faculty faculty = new Faculty(fullName,id,department,Rank);
					pList.add(faculty);
					System.out.println(" ");
					System.out.println("Faculty added!");
					System.out.println(" ");
					break;
		
				// Student Information
				case 2:
			
					System.out.println(" ");
					myScanner.nextLine();
					System.out.println("Enter the student's information");
					System.out.println(" ");
					do {
						System.out.print("Name of Student: ");
						
						// Error Handling
						try {
							fullName = myScanner.nextLine();
							char[] array = fullName.toCharArray();
							for(char c: array) {
								if(!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))){ 
									System.out.println("Please only enter names without digits"); 
									System.out.println(" ");
									System.out.print("Name of Student: ");
									fullName = myScanner.nextLine();
								}
							}
						}catch(InputMismatchException e) {
							myScanner.next();
							System.out.println("Sorry, the entered Name is invalid!");
						}
					}while(!(fullName.isEmpty() == false)); 
					
					  while(true) {
						System.out.print("ID: ");
						id = myScanner.nextLine();
						if(id.matches("^[A-z]{2}[0-9]{4}$")) {
							boolean dupe = false;
							for(Person person: pList) {
								if(person.getId().equals(id)) {
								dupe = true;
								break;
							}
						}
						if(!dupe) {
							break;
						}
						
						// Error handling
						else { 
							System.out.println(" ");
							System.out.println("Id already exists. please input a unique id");
							System.out.println(" ");
							}
						}else {
							System.out.println(" ");
							System.out.println("Invalid id format. must be LetterLetterDigitDigitDigitDigit");
							System.out.println(" ");
							}
					}
					 
					
					do {
						System.out.print("GPA: ");
						try {
							GPA = myScanner.nextDouble();
						}catch(InputMismatchException e) {
							myScanner.next();
							System.out.println("Sorry, the entered GPA is invalid!");
						}
					}while(!(GPA > 0));
	
					do {
						System.out.print("Credit hours: ");
						try {
							creditHours = myScanner.nextInt();
						}catch(InputMismatchException e) {
							myScanner.nextLine();
							System.out.println("Sorry, the entered credit hours is invalid!");
						}
					}while(!(creditHours > 0));
					
					// Add student based on user's input
					Student student = new Student(fullName, id, GPA, creditHours);
					pList.add(student);
					System.out.println(" ");
					System.out.println("Student added!");
					System.out.println(" ");
					break;
				
				// Student Invoice
				case 3:
					boolean flag = false;
					System.out.println(" ");
					myScanner.nextLine();
						System.out.print("Enter the student's id: ");
							id = myScanner.nextLine();	
							if(id.matches("^[A-z]{2}[0-9]{4}$")) {
								flag = false;
								for(Person person: pList) {
									if((person instanceof Student) && (person.getId().equalsIgnoreCase(id))) {
										flag = true;
										System.out.println("Here is the tuition invoice for"+ person.getFullName()+": ");
										person.print();
										break;
									}
								}
								
							// User input not following ID specifications 
							}while(!(id.matches("^[A-z]{2}[0-9]{4}$"))){
								System.out.println(" ");
								System.out.println("invalid id Format. must be LetterLetterDigitDigitDigitDigit");
								System.out.println(" ");
								System.out.print("Enter the student's id: ");
								id = myScanner.nextLine();
							}
							
							// Student not fount
							if(!flag) {
								System.out.println(" ");
								System.out.println("Sorry, student was not found!");
								System.out.println(" ");
							}
							break;
					
				// Print Faculty Information
				case 4:
					boolean flag1 = false;
					myScanner.nextLine(); 
					System.out.println(" ");
					System.out.print("Enter the ID of the faculty for information: ");
					id = myScanner.nextLine();
					if(id.matches("^[A-z]{2}[0-9]{4}$")) {
						flag1 = false;
						for(Person person: pList) {
							if((person instanceof Faculty) && (person.getId().equalsIgnoreCase(id))) {
								Faculty facid = (Faculty) person;
								facid.print();
								flag1 = true;
								break;
							}
						}
							
						// User input does not match the required id format
						}while(!(id.matches("^[A-z]{2}[0-9]{4}$"))) {
							System.out.println(" ");
							System.out.println("Invalid id Format. must be LetterLetterDigitDigitDigitDigit");
							System.out.println(" ");
							System.out.println("Enter the ID of the faculty for information: ");
							id = myScanner.nextLine();
						}
						
						// Faculty was not found
						if(!flag1) {
							System.out.println(" ");
							System.out.println("Faculty not found in system");
							System.out.println(" ");
						}
						break;
				
				// Staff Information
				case 5:
					System.out.println(" ");
					myScanner.nextLine();
					do {
						System.out.print("Name of staff member: ");
						
						// Error Handling
						try {
							fullName = myScanner.nextLine();
							char[] array = fullName.toCharArray();
							for(char c: array) {
								if(!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))){ 
									System.out.println("Please only enter names without digits"); 
									System.out.println(" ");
									System.out.print("Name of Student: ");
									fullName = myScanner.nextLine();
								}
							}
						}catch(InputMismatchException e) {
							myScanner.next();
							System.out.println("Sorry, the entered Name is invalid!");
						}
					}while(!(fullName.isEmpty() == false)); 
					
					while(true) {
						System.out.print("Id: ");
						id = myScanner.nextLine();
						if(id.matches("^[A-z]{2}[0-9]{4}$")) { 
							boolean dupe = false;
							for(Person person : pList) {
								if(person.getId().equals(id)) {
									dupe = true;
									break;
								}
							}
							if(!dupe) {
								break;
							}
							
							// Error Handling
							else { 
								System.out.println(" ");
								System.out.println("Id already exists. Please enter a unique id");
								System.out.println(" ");
								}
							}else {
								System.out.println(" ");
								System.out.println("Invalid id format. Must be LetterLetterDigitDigitDigitDigit");
								System.out.println(" ");
							}
						}
					
						System.out.print("Department: ");
						department = myScanner.nextLine();
						
						// Error Handling
						while(!(department.equalsIgnoreCase("Mathematics")||department.equalsIgnoreCase("English")||
								department.equalsIgnoreCase("Engineering"))) {
							System.out.println(" ");
							System.out.println("Sorry, entered department ("+department+") is invalid.. Please select Mathematics, English, or Engineering.");
							System.out.println(" ");
							System.out.println("Department: ");
							department = myScanner.nextLine();
						}
						
						System.out.print("Status (Enter Part Time, or Full Time): ");
						String status = myScanner.nextLine();
						
						// Error Handling
						while (!(status.equalsIgnoreCase("Part time") || status.equalsIgnoreCase("Full time"))) {
							System.out.println(" ");
							System.out.println("Sorry, entered status ("+status+") is invalid");
							System.out.println(" ");
							System.out.println("Status (Enter Part Time, or Full Time): ");
							status = myScanner.nextLine();
						}
						
						// Add new staff memeber based on user's input
						Staff staff = new Staff(fullName, id, department, status);
						pList.add(staff);
						System.out.println(" ");
						System.out.println("Staff member added!");
						System.out.println(" ");
						break;
				
				// Print Staff Information
				case 6: 
					boolean flag2 = false;
					myScanner.nextLine();
					System.out.print("Enter the staff member's ID: ");
					id = myScanner.nextLine();
					if(id.matches("^[A-z]{2}[0-9]{4}$")) {
						
					flag2 = false;
					
					for(Person person: pList) {
						if(person instanceof Staff && person.getId().equals(id)) {
							Staff staff1 = (Staff) person;
							
							staff1.print();
							flag2 = true;
							break;
						}
					}
				
				// User's input does not match the required ID format
				}while(!(id.matches("^[A-z]{2}[0-9]{4}$"))) {
					System.out.println(" ");
					System.out.println("Invalid id format. must be LetterLetterDigitDigitDigitDigit");
					System.out.println(" ");
					System.out.println("Enter the staff member's ID: ");
					id = myScanner.nextLine();
				}
				
					// Staff not found
					if(!flag2) {
						System.out.println(" ");
						System.out.println("No staff member is in our system");
						System.out.println(" ");
					}
					break;
					
				// Delete Information
				case 7:
					boolean flag3 = false;
					System.out.println(" ");
					myScanner.nextLine();
					System.out.print("Enter the id of the person to delete: ");
					id = myScanner.nextLine();
					if(id.matches("^[A-z]{2}[0-9]{4}$")) {
					flag3 = false;
					
					// Deleted Person's information IF FOUND
					for(Person person: pList) {
						if(person.getId().equals(id)) {
							pList.remove(person);
							System.out.println("Person deleted");
							
							flag3 = true;
							break;
		
						}
					}
					
					// Invalid ID format
					}while(!(id.matches("^[A-z]{2}[0-9]{4}$"))) {
						System.out.println(" ");
						System.out.println("Invalid id format. must be LetterLetterDigitDigitDigitDigit");
						System.out.println(" ");
						System.out.println("Enter the id of the person to delete: ");
						id = myScanner.nextLine();
					}
					
					// User not found
					if(!flag3) {
						System.out.println(" ");
						System.out.println("Sorry, no such person exists in the database!");
						System.out.println(" ");
					}
					break;
					
				// Report Information
				case 8:
					String option= "";
					int order;
					
					myScanner.nextLine();
					System.out.print("Would you like to create the report? (Y/N): ");
					option = myScanner.nextLine();
					
					if(option.equalsIgnoreCase("Y")) {
						System.out.print("Would you like to sort your students by descending gpa or name? (1 for gpa, 2 for name): ");
						order = myScanner.nextInt();
						myScanner.nextLine(); //
						report(pList,order);
					}
					System.out.println("Goodbye!");
					System.exit(0);
					break;
					
				// Entries outside of the valid entries listed
				default:
					System.out.println("Invalid selection. Please try again.");
					break;
					}
					
			} catch(InputMismatchException e) {
				myScanner.next();
				System.out.println("Invalid entry, entry needs to be an integer from 1-8!");
			}
				
		} while(!(choice > 0));
	}
}
	
	// Report Creations Function
	private static void report(ArrayList<Person>pList,int order) {
		Collections.sort(pList, new Comparator<Person>(){
		
		@Override
		public int compare(Person p1, Person p2) {
			if(order == 1) {
				if(p1 instanceof Student && p2 instanceof Student) {
					Student s1 = (Student) p1;
					Student s2 = (Student) p2;
					int res = Double.compare(s2.getGpa(), s1.getGpa());
					if(res == 0) {
						return s1.getFullName().compareToIgnoreCase(s2.getFullName());
					}
					return res;
				} else {
					return p1.getFullName().compareToIgnoreCase(p2.getFullName());
				}
			} else if (order == 2) {
				return p1.getFullName().compareToIgnoreCase(p2.getFullName());
			}
			return 0;
		}
	});
		
		try {
			FileWriter fileWriter = new FileWriter("report.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			printWriter.println("\tReport created on " + java.time.LocalDate.now());
			printWriter.println("\t*********************");
			printWriter.println(" ");
			
			// faculty
			printWriter.println("Faculty Members");
			printWriter.println("-----------------");
			int facCount = 0;
			for(Person person: pList) {
				if(person instanceof Faculty) {
					Faculty faculty = (Faculty) person;
					printWriter.println(++facCount + ". " + faculty.getFullName() + " \nID: " + faculty.getId() 
					+ " \n" + faculty.getRank() + ", " + faculty.getDepartment());
					printWriter.println(" ");
				}
			}
			
			// staff
			printWriter.println("\n Staff Members");
			printWriter.println("-----------------");
			int staffCount = 0;
			for(Person person : pList) {
				if(person instanceof Staff) {
					Staff staff = (Staff) person;
					printWriter.println(++staffCount + ". " + staff.getFullName() + " \nID: " + staff.getId()+ " \n" + staff.getDepartment() + ", " + staff.getStatus());
					printWriter.println(" ");
				}
			}
			
			// Students
			printWriter.println("\n Students (Sorted by GPA in descending order)");
			printWriter.println("------------------");
			int studentCount = 0;
			for(Person person : pList) {
				if(person instanceof Student) {
					Student student = (Student) person;
					printWriter.println(++studentCount + ". " + student.getFullName() + " \nID: " + student.getId()+ " \nGPA: " + student.getGpa() + " \nCredit hours: " + student.getCredithours());
					printWriter.println(" ");
				}
			}
			
			printWriter.close();
			System.out.println("Report created and saved in report.txt");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error creating the report");
		}
			
	}
	
	
}

// Person Function (Information shared across other functions)
abstract class Person{
	
	// Variable Initialization
	private String fullName;
	private String id;
				
					
	public Person() {
		fullName = "";
		id = "";
	}
					

	public Person(String fullName, String id) {
		this.fullName = fullName;
		this.id = id;
	}
						
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public abstract void print();
	
	
}


// Student Function 
class Student extends Person{
	
	private double gpa;
	private int Credithours;
	

	public Student(String fullName, String id, double gpa, int Credithours) {
		super(fullName, id);
		this.gpa = gpa;
		this.Credithours = Credithours;
	}
	
	@Override 
	public void print() {
		System.out.println("--------------------------------------------------------------------------");
		System.out.println(getFullName() + "\t\t\t" + getId());
		System.out.println(" ");
		System.out.println("Credit Hours: "+Credithours+ " ($236.45/credit hour)");
		System.out.println(" ");
		System.out.println("Fees: $52");
		
		double rate = getCredithours() * 236.45 + 52.0; 
		System.out.println(" ");
		
		if(getGpa() >= 3.85) {
			double discountRate = (getCredithours() * 236.45 + 52.0) * 0.25;
			double percentOff = rate - discountRate;
			System.out.println(" ");
			System.out.printf("Total Payment (after discount): $%,.2f \t($%,.2f discount applied)", percentOff, discountRate);
			System.out.println(" ");
			System.out.println("---------------------------------------------------------------------------");
		}
		else {
			System.out.printf("Total Payment (after discount): $%,.2f \t($0 discount applied)",rate);
			System.out.println(" ");
			System.out.println("---------------------------------------------------------------------------");
		}
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getCredithours() {
		return Credithours;
	}

	public void setCredithours(int credithours) {
		Credithours = credithours;
	}
}

// Employee Function (Information shared across Employees)
abstract class Employee extends Person{
	
	private String department;
	
	public Employee(String fullName, String id, String department) {
		super(fullName, id);
		this.department = department;
	}
	
	@Override 
	public abstract void print();

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}

// Faculty Function
class Faculty extends Employee{
	
	public String fullName;
	public String id;
	public String department;
	private String rank;
	
	public Faculty(String fullName, String id, String department, String rank) {
		super(fullName, id, department);
		this.rank = rank;
	}
	
	@Override
	public void print() {
		System.out.println(" ");
		System.out.println("Faculty information: ");
		System.out.println("-------------------------------------------");
		System.out.println(getFullName() + "\t\t" + getId());
		System.out.println(getDepartment() + " " + "Department,\t"+ rank);
		System.out.println("-------------------------------------------");
		System.out.println(" ");
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
}

// Staff Function
class Staff extends Employee{
	private String status;
	
	public Staff(String fullName, String id, String department, String status) {
		super(fullName, id, department);
		this.status = status;
	}
	
	@Override
	public void print() {
		System.out.println("-----------------------------------------------------------");
		System.out.println(getFullName() + "\t\t" + getId());
		System.out.println(getDepartment() + " " + "Department,\t" + status);
		System.out.println("------------------------------------------------------------");
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

