import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * JUnit test fixture for {@code NaturalNumber}'s constructors and kernel
 * methods.
 *
 * @author Shyam Sai Bethina and Yihone Chu
 *
 */
public abstract class NaturalNumberTest {

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new number
     * @ensures constructorTest = 0
     */
    protected abstract NaturalNumber constructorTest();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorTest = i
     */
    protected abstract NaturalNumber constructorTest(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorTest)
     */
    protected abstract NaturalNumber constructorTest(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * implementation under test and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorTest = n
     */
    protected abstract NaturalNumber constructorTest(NaturalNumber n);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @return the new number
     * @ensures constructorRef = 0
     */
    protected abstract NaturalNumber constructorRef();

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param i
     *            {@code int} to initialize from
     * @return the new number
     * @requires i >= 0
     * @ensures constructorRef = i
     */
    protected abstract NaturalNumber constructorRef(int i);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param s
     *            {@code String} to initialize from
     * @return the new number
     * @requires there exists n: NATURAL (s = TO_STRING(n))
     * @ensures s = TO_STRING(constructorRef)
     */
    protected abstract NaturalNumber constructorRef(String s);

    /**
     * Invokes the appropriate {@code NaturalNumber} constructor for the
     * reference implementation and returns the result.
     *
     * @param n
     *            {@code NaturalNumber} to initialize from
     * @return the new number
     * @ensures constructorRef = n
     */
    protected abstract NaturalNumber constructorRef(NaturalNumber n);

    /**
     * Test the no argument constructor.
     */
    @Test
    public void testNoArgConstructor() {
        NaturalNumber result = this.constructorTest();

        NaturalNumber expected = this.constructorRef();

        assertEquals(expected, result);
    }

    /**
     * Test the int argument constructor with 0.
     */
    @Test
    public void testIntConstructor0() {
        NaturalNumber result = this.constructorTest(0);

        NaturalNumber expected = this.constructorRef(0);

        assertEquals(expected, result);
    }

    /**
     * Test the int argument constructor.
     */
    @Test
    public void testIntConstructor() {
        final int number = 5;
        NaturalNumber result = this.constructorTest(number);

        NaturalNumber expected = this.constructorRef(number);

        assertEquals(expected, result);
    }

    /**
     * Test the int argument constructor with long input.
     */
    @Test
    public void testIntConstructorLong() {
        final int number = 5;
        NaturalNumber result = this.constructorTest(123456789);

        NaturalNumber expected = this.constructorRef(123456789);

        assertEquals(expected, result);
    }

    /**
     * Test the String argument constructor.
     */
    @Test
    public void testStringConstructor() {
        NaturalNumber result = this.constructorTest("5");

        NaturalNumber expected = this.constructorRef("5");

        assertEquals(expected, result);

    }

    /**
     * Test the String argument constructor with "0".
     */
    @Test
    public void testStringConstructor0() {
        NaturalNumber result = this.constructorTest("0");

        NaturalNumber expected = this.constructorRef("0");

        assertEquals(expected, result);

    }

    /**
     * Test the String argument constructor with really long input.
     */
    @Test
    public void testStringConstructorLong() {
        NaturalNumber result = this.constructorTest("123456789");

        NaturalNumber expected = this.constructorRef("123456789");

        assertEquals(expected, result);

    }

    /**
     * Test the Natural Number argument constructor.
     */
    @Test
    public void testNNConstructor() {
        final int number = 5;
        NaturalNumber result = this.constructorTest(new NaturalNumber2(number));

        NaturalNumber expected = this
                .constructorRef(new NaturalNumber2(number));

        assertEquals(expected, result);
    }

    /**
     * Test the Natural Number argument constructor with 0.
     */
    @Test
    public void testNNConstructor0() {
        NaturalNumber result = this.constructorTest(new NaturalNumber2());

        NaturalNumber expected = this.constructorRef(new NaturalNumber2());

        assertEquals(expected, result);
    }

    /**
     * Test the Natural Number argument constructor with long input.
     */
    @Test
    public void testNNConstructorLong() {
        NaturalNumber result = this
                .constructorTest(new NaturalNumber2(12345678));

        NaturalNumber expected = this
                .constructorRef(new NaturalNumber2(12345678));

        assertEquals(expected, result);
    }

    /**
     * Test edge with multiplyBy10 method.
     */
    @Test
    public void testMultiplyBy10() {
        NaturalNumber result = this.constructorTest();
        result.multiplyBy10(0);

        NaturalNumber expected = this.constructorRef();
        expected.multiplyBy10(0);
        assertEquals(expected, result);
    }

    /**
     * Test strange case with multiplyBy10 method.
     */
    @Test
    public void testMultiplyBy102() {
        NaturalNumber result = this.constructorTest(10);
        result.multiplyBy10(0);
        System.out.println(result);

        NaturalNumber expected = this.constructorRef(10);
        expected.multiplyBy10(0);
        System.out.println(expected);
        assertEquals(expected, result);
    }

    /**
     * Test routine case with multiplyBy10 method.
     */
    @Test
    public void testMultiplyBy103() {
        NaturalNumber result = this.constructorTest(1);
        result.multiplyBy10(0);

        NaturalNumber expected = this.constructorRef(1);
        expected.multiplyBy10(0);
        assertEquals(expected, result);
    }

    /**
     * Test routine case with multiplyBy10 method.
     */
    @Test
    public void testMultiplyBy104() {
        NaturalNumber result = this.constructorTest(10);
        result.multiplyBy10(7);

        NaturalNumber expected = this.constructorRef(10);
        expected.multiplyBy10(7);
        assertEquals(expected, result);
    }

    /**
     * Test strange case with divideBy10 method.
     */
    @Test
    public void testDivideBy101() {
        NaturalNumber result = this.constructorTest("0");
        result.divideBy10();

        NaturalNumber expected = this.constructorRef("0");
        expected.divideBy10();
        assertEquals(expected, result);
    }

    /**
     * Test strange case with divideBy10 method.
     */
    @Test
    public void testDivideBy102() {
        NaturalNumber result = this.constructorTest();
        result.divideBy10();

        NaturalNumber expected = this.constructorRef();
        expected.divideBy10();
        assertEquals(expected, result);
    }

    /**
     * Test edge case with divideBy10 method.
     */
    @Test
    public void testDivideBy103() {
        NaturalNumber result = this.constructorTest(1);
        result.divideBy10();

        NaturalNumber expected = this.constructorRef(1);
        expected.divideBy10();
        assertEquals(expected, result);
    }

    /**
     * Test routine case with divideBy10 method.
     */
    @Test
    public void testDivideBy104() {
        NaturalNumber result = this.constructorTest(101);
        result.divideBy10();

        NaturalNumber expected = this.constructorRef(101);
        expected.divideBy10();
        assertEquals(expected, result);
    }

    /**
     * Test strange case with isZero method.
     */
    @Test
    public void testisZero1() {
        NaturalNumber result = this.constructorTest(0);
        boolean resultTest = result.isZero();

        NaturalNumber expected = this.constructorRef(0);
        boolean expectedTest = expected.isZero();
        assertEquals(expected, result);
        assertEquals(expectedTest, resultTest);
    }

    /**
     * Test edge case with isZero method.
     */
    @Test
    public void testisZero3() {
        NaturalNumber result = this.constructorTest();
        boolean resultTest = result.isZero();

        NaturalNumber expected = this.constructorRef();
        boolean expectedTest = expected.isZero();

        assertEquals(expected, result);
        assertEquals(expectedTest, resultTest);
    }

    /**
     * Test routine case with isZero method.
     */
    @Test
    public void testisZero4() {
        NaturalNumber result = this.constructorTest(20);
        boolean resultTest = result.isZero();

        NaturalNumber expected = this.constructorRef(20);
        boolean expectedTest = expected.isZero();
        assertEquals(expected, result);
        assertEquals(expectedTest, resultTest);
    }

}
