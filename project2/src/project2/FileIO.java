package project2;

import java.io.*;
import java.util.Scanner;


public class FileIO {

public static void Welcome() throws IOException {
	Scanner scan = new Scanner(System.in);
	System.out.println("Welcome!\nType login or register: ");
	String chose = scan.nextLine();
	while(true) {
		if(chose.equals("login")) {
			FileIO.Login();
			break;}
		else if (chose.equals("register")) {
			FileIO.Register();
			break;}
		else
			System.out.println("You have written wrong input, please type login or register!");
			chose = scan.nextLine();
			}
	scan.close();
	
	
}
public static void Register() throws IOException {
	Scanner scannerID = new Scanner(System.in);
	System.out.println("Enter your ID: ");
	String id = scannerID.nextLine();
	while(id.length() < 6) {
		
		System.out.println("The ID must be longer than 6 characters. Please write another ID!: ");
		id = scannerID.nextLine();
	}
	
	while (checkID(id)) {
		
		System.out.println("The ID has already been taken. Please write another ID!: ");
		id = scannerID.nextLine();
		if (checkID(id)) {
			continue;}
		}
	Scanner scannerPW1 = new Scanner(System.in);
	System.out.println("Enter your password: ");
	String pw1 = scannerPW1.nextLine();
	while(pw1.length() < 6) {
		
		System.out.println("The password must be longer than 6 characters. Please write another password!: ");
		pw1 = scannerPW1.nextLine();
		}
	
		while (true) {
	Scanner scannerPW2 = new Scanner(System.in);
	System.out.println("Enter your password again: ");
	String pw2 = scannerPW2.nextLine();
	if(!pw1.equals(pw2)) {
		System.out.println("Passwords don't match!");
		continue;
	}
	System.out.println("Registering successful!");
	scannerID.close();
	scannerPW1.close();
	scannerPW2.close();
	break;
	}

	FileWriter fw = null;
	BufferedWriter bw = null;
	PrintWriter pw = null;
	
	
	
	try {
		fw = new FileWriter("data.txt", true);
		bw = new BufferedWriter(fw);
		pw = new PrintWriter(bw);
		
		pw.print(id + " " + pw1);
		pw.flush();
	}
	finally {
		try {
			pw.close();
			bw.close();
			fw.close();
		} catch (IOException io) {
	}}
		
	
	try (FileWriter f = new FileWriter("data.txt", true);
			BufferedWriter b = new BufferedWriter(f);
			PrintWriter p = new PrintWriter(b);) {
			p.println();
			}
}


public static void Login() throws FileNotFoundException {
	Scanner scannerID = new Scanner(System.in);
	Scanner scannerPW = new Scanner(System.in);
	boolean successful = false;
	while (!successful) {
	System.out.println("Enter your ID: ");
	String id = scannerID.nextLine();
	
	System.out.println("Enter your password: ");
	String pw = scannerPW.nextLine();
	
	Scanner scanner = new Scanner(new FileInputStream("data.txt"));
	
	while(scanner.hasNextLine()) {
	String line = scanner.nextLine();
	if (line.equals(id + " " + pw)) {
		System.out.println("Login successful!");
		successful = true;
	}}
	scanner.close();
	if(successful == false) {
		System.out.println("Your ID or password is wrong! Please try again!");
	}}
	
	scannerID.close();
	scannerPW.close();

}


public static boolean checkID(String newID) throws FileNotFoundException {
	
	Scanner scanner = new Scanner(new FileInputStream("data.txt"));
	while(scanner.hasNextLine()) {
		String line = scanner.nextLine();
		String[] idPw = new String[2];
		idPw = line.split(" ", 2);
		String id = idPw[0];
		
		if (id.equals(newID)) {
			return true;
		}}
	return false;
}}
