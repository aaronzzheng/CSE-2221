import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Homework #12
 *
 * @author Aaron Zheng
 *
 */
public final class Recursion1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Recursion1() {
    }

    /**
     * Returns the number of digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to count
     * @return the number of digits of {@code n}
     * @ensures numberOfDigits = [number of digits of n]
     */
    private static int numberOfDigits(NaturalNumber n) {
        int count = 0;
        NaturalNumber temp = new NaturalNumber2(0);
        temp.copyFrom(n);
        while (!temp.isZero()) {
            temp.divideBy10();
            count++;
        }
        return count;
    }

    /**
     * Returns the sum of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to add
     * @return the sum of the digits of {@code n}
     * @ensures sumOfDigits = [sum of the digits of n]
     */
    private static int sumOfDigits(NaturalNumber n) {
        int sum = 0;
        NaturalNumber temp = new NaturalNumber2(n);
        while (!temp.isZero()) {
            sum += temp.divideBy10();
        }
        return sum;
    }

    /**
     * Returns the sum of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to add
     * @return the sum of the digits of {@code n}
     * @ensures sumOfDigits = [sum of the digits of n]
     */
    private static NaturalNumber sumOfDigitsNN(NaturalNumber n) {
        NaturalNumber temp = new NaturalNumber2(n);
        int sum1 = 0;
        while (!temp.isZero()) {
            sum1 += temp.divideBy10();
        }
        NaturalNumber sum = new NaturalNumber2(sum1);
        return sum;
    }

    /**
     * Divides {@code n} by 2.
     *
     * @param n
     *            {@code NaturalNumber} to be divided
     * @updates n
     * @ensures 2 * n <= #n < 2 * (n + 1)
     */
    private static void divideBy2(NaturalNumber n) {
        int remainder1 = n.divideBy10();
        int remainder2 = n.divideBy10();

        if (remainder2 % 2 != 0) {
            remainder1 += 10;
        }
        remainder1 /= 2;
        n.multiplyBy10(remainder2);
        if (!n.isZero()) {
            divideBy2(n);
        }
        n.multiplyBy10(remainder1);
    }

    /**
     * Checks whether a {@code String} is a palindrome.
     *
     * @param s
     *            {@code String} to be checked
     * @return true if {@code s} is a palindrome, false otherwise
     * @ensures isPalindrome = (s = rev(s))
     */
    private static boolean isPalindrome(String s) {
        boolean x = true;
        int length = s.length();
        int i = 0;
        while (x && i < length / 2) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                x = false;
            }
            i++;
        }

        return x;
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
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        out.println("Enter a number: ");
        NaturalNumber num = new NaturalNumber2(in.nextLine());
        out.println("Number of digits in your number: " + numberOfDigits(num));
        out.println("Sum of digits of your number (int): " + sumOfDigits(num));
        out.println("Sum of digits of your number (NN): " + sumOfDigitsNN(num));
        out.print("Quotient of your number when divided by 2 (NN): ");
        divideBy2(num);
        out.println(num);
        out.println("Enter a string: ");
        String s = in.nextLine();
        if (isPalindrome(s)) {
            out.println(s + " is a palindrome.");
        } else {
            out.println(s + " is not a palindrome.");
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
