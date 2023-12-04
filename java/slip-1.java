import java.io.*;

class LowercaseInputStream extends FilterInputStream {

    public LowercaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        for (int i = off; i < off + result; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return result;
    }
}

public class IODecoratorExample {

    public static void main(String[] args) {
        try {
            // Wrap System.in with LowercaseInputStream
            LowercaseInputStream lowerInput = new LowercaseInputStream(System.in);

            System.out.println("Enter text (Ctrl + D to end):");

            int c;
            while ((c = lowerInput.read()) != -1) {
                System.out.print((char) c);
            }

            lowerInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
