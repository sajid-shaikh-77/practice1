import java.util.Enumeration;
import java.util.Iterator;

// Enumeration interface (existing interface)
interface MyEnumeration {
	boolean hasMoreElements();

	Object nextElement();
}

// Concrete implementation of Enumeration interface
class MyConcreteEnumeration implements MyEnumeration {
	private int currentIndex = 0;
	private final String[] elements = { "One", "Two", "Three", "Four", "Five" };

	@Override
	public boolean hasMoreElements() {
		return currentIndex < elements.length;
	}

	@Override
	public Object nextElement() {
		if (hasMoreElements()) {
			return elements[currentIndex++];
		}
		return null;
	}
}

// Adapter to convert Enumeration to Iterator
class EnumerationAdapter implements Iterator<Object> {
	private final MyEnumeration enumeration;

	public EnumerationAdapter(MyEnumeration enumeration) {
		this.enumeration = enumeration;
	}

	@Override
	public boolean hasNext() {
		return enumeration.hasMoreElements();
	}

	@Override
	public Object next() {
		return enumeration.nextElement();
	}

	// Unsupported operation
	@Override
	public void remove() {
		throw new UnsupportedOperationException("remove() method is not supported by EnumerationAdapter");
	}
}

public class AdapterPatternExample {

	public static void main(String[] args) {
		// Using the existing Enumeration
		MyEnumeration enumeration = new MyConcreteEnumeration();

		// Creating an Adapter to convert Enumeration to Iterator
		Iterator<Object> iterator = new EnumerationAdapter(enumeration);

		// Using the Iterator interface
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
