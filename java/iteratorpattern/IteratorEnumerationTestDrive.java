package iteratorpattern;

import java.util.*;

public class IteratorEnumerationTestDrive {
	public static void main (String args[]) {
		
		String[] str= {"Apple" ,"Tomato", "Banana", "Orange"};
		
		ArrayList l = new ArrayList(Arrays.asList(str));
		Enumeration enumeration = new IteratorEnumeration(l.iterator());
		while (enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}
	}
}
