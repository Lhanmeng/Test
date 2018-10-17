package day1801;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	public static void main(String[] args) throws Exception {
		Socket s = 
		 new Socket("127.0.0.1",8000);
		
		BufferedReader in = 
		 new BufferedReader(
		 new InputStreamReader(
		 s.getInputStream(), "GBK"));
		PrintWriter out = 
		 new PrintWriter(
		 new OutputStreamWriter(
		 s.getOutputStream(), "GBK"));
		
		while(true) {
			System.out.print(" ‰»Î£∫");
			String str = new Scanner(System.in).nextLine();
			out.println(str);
			out.flush();
			str = in.readLine();
			System.out.println(str);
		}
		
	}
}




