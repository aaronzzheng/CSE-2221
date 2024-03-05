import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * A program that allows users to to enter a starting value from which the
 * program computes and outputs the corresponding Hailstone series. But instead
 * of computing with Java primitive ints, you will use NaturalNumber objects.
 *
 * @author Aaron Zheng
 *
 */
public final class naturalnumber {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private naturalnumber() {
    }

    /**
     * Swaps the two given {@code NaturalNumber}s.
     *
     * @param n1
     *            the first {@code NaturalNumber}
     * @param n2
     *            the second {@code NaturalNumber}
     * @updates n1
     * @updates n2
     * @ensures n1 = #n2 and n2 = #n1
     */
    private static void swapNN(NaturalNumber n1, NaturalNumber n2) {

        /*
         * NaturalNumber temp = new NaturalNumber1L(); temp.copyFrom(n2);
         * n2.copyFrom(n1); n1.copyFrom(temp);
         */

        NaturalNumber temp = new NaturalNumber1L();
        temp.transferFrom(n2);
        n2.transferFrom(n1);
        n1.transferFrom(temp);

    }

    /**
     * Squares a given {@code NaturalNumber}.
     *
     * @param n
     *            the number to square
     * @updates n
     * @ensures n = #n * #n
     */
    private static void square(NaturalNumber n) {
        n.power(2);
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        NaturalNumber n1 = new NaturalNumber1L(1);
        NaturalNumber n2 = new NaturalNumber1L(2);
        //swapNN(n1, n2);

        //out.println("n1:" + n1 + ",n2:" + n2);

        square(n2);
        out.println("n2 squared: " + n2);

        in.close();
        out.close();
    }

}
