import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and SpotBugs warnings).
 *
 * @author P. Bucci
 */
public final class HelloWorld {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private HelloWorld() {
        // no code needed here
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        boolean equal = true;
        int i = 0;
        String s1 = "abCd";
        String s2 = "ab";
        int length = s1.length();

        while (equal && i < length) {
            equal = (s1.charAt(i) == s2.charAt(i));
            i++;
        }
        out.print(equal);
    }
}
