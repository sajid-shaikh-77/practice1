
/*
 * 
 * Write a Java Program to implement I/O Decorator for converting uppercase letters to lower case letters.
 * 
 * 
 */

package decorator;

import java.io.*;

public class InputTest {
	public static void main(String[] args) throws IOException {
		int c;

		try {
			InputStream in = 
				new LowerCaseInputStream(
					new BufferedInputStream(
						new FileInputStream("C:\\Users\\AliAyesha\\eclipse-workspace\\DesignPatterns\\src\\decorator\\test.txt")));

			while((c = in.read()) >= 0) {
				System.out.print((char)c);
			}

			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
