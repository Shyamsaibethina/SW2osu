import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.sequence.Sequence;

/**
 * JUnit test fixture for {@code Sequence<String>}'s constructor and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class SequenceTest {

    /**
     * Invokes the appropriate {@code Sequence} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new sequence
     * @ensures constructorTest = <>
     */
    protected abstract Sequence<String> constructorTest();

    /**
     * Invokes the appropriate {@code Sequence} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new sequence
     * @ensures constructorRef = <>
     */
    protected abstract Sequence<String> constructorRef();

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsTest = [entries in args]
     */
    private Sequence<String> createFromArgsTest(String... args) {
        Sequence<String> sequence = this.constructorTest();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    /**
     *
     * Creates and returns a {@code Sequence<String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the entries for the sequence
     * @return the constructed sequence
     * @ensures createFromArgsRef = [entries in args]
     */
    private Sequence<String> createFromArgsRef(String... args) {
        Sequence<String> sequence = this.constructorRef();
        for (String s : args) {
            sequence.add(sequence.length(), s);
        }
        return sequence;
    }

    /**
     * Routine Test case with seq1 = <"2","4","6"> and addedOn = "8" "6">.
     */
    @Test
    public void test1() {
        /*
         * Set up variables and call method under test
         */
        Sequence<String> seq1 = this.createFromArgsTest("2", "4", "6");
        Sequence<String> expectedSeq1 = this.createFromArgsRef("8", "2", "4",
                "6");
        String addedOn = "8";
        seq1.add(0, addedOn);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
    }

    /**
     * Boundary Test case with seq1 = <> and addedOn = "".
     */
    @Test
    public void test2() {
        /*
         * Set up variables and call method under test
         */
        Sequence<String> seq1 = this.createFromArgsTest();
        Sequence<String> expectedSeq1 = this.createFromArgsRef("2", "4", "6");
        String addedOn = "";
        seq1.add(0, addedOn);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
    }

    /**
     * Challenging Test case with seq1 = <"1","2","3"> and addedOn = "9".
     */
    @Test
    public void test3() {
        /*
         * Set up variables and call method under test
         */
        Sequence<String> seq1 = this.createFromArgsTest("1", "2", "3");
        Sequence<String> expectedSeq1 = this.createFromArgsRef("1", "9", "2",
                "3");
        String addedOn = "9";
        seq1.add(seq1.length() - 2, addedOn);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
    }

    /**
     * Routine Test case with seq1 = <"1","2","3">.
     */
    @Test
    public void test4() {
        /*
         * Set up variables and call method under test
         */
        Sequence<String> seq1 = this.createFromArgsTest("1", "2", "3");
        Sequence<String> expectedSeq1 = this.createFromArgsRef("1", "2");

        seq1.remove(2);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
    }

    /**
     * Boundary Test case with seq1 = <"1">.
     */
    @Test
    public void test5() {
        /*
         * Set up variables and call method under test
         */
        Sequence<String> seq1 = this.createFromArgsTest("1");
        Sequence<String> expectedSeq1 = this.createFromArgsRef();

        seq1.remove(0);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
    }

    /**
     * Challenging Test case with seq1 = <"1","2","3">.
     */
    @Test
    public void test6() {
        /*
         * Set up variables and call method under test
         */
        Sequence<String> seq1 = this.createFromArgsTest("1", "2", "3");
        Sequence<String> expectedSeq1 = this.createFromArgsRef("2", "3");

        seq1.remove(seq1.length() - seq1.length());

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
    }

    /**
     * Routine Test case with seq1 = <"1","2","3">.
     */
    @Test
    public void test7() {
        /*
         * Set up variables and call method under test
         */
        Sequence<String> seq1 = this.createFromArgsTest("1", "2", "3");
        Sequence<String> expectedSeq1 = this.createFromArgsRef("1", "2", "3");
        int lengthOfTest = seq1.length();
        int lengthOfRef = 3;

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(lengthOfTest, lengthOfRef);
    }

    /**
     * Boundary Test case with seq1 = <>.
     */
    @Test
    public void test8() {
        /*
         * Set up variables and call method under test
         */
        Sequence<String> seq1 = this.createFromArgsTest();
        Sequence<String> expectedSeq1 = this.createFromArgsRef();
        int lengthOfTest = seq1.length();
        int lengthOfRef = 0;

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(lengthOfTest, lengthOfRef);
    }

    /**
     * Challenging Test case with seq1 = <"">.
     */
    @Test
    public void test9() {
        /*
         * Set up variables and call method under test
         */
        Sequence<String> seq1 = this.createFromArgsTest("");
        Sequence<String> expectedSeq1 = this.createFromArgsRef("");
        int lengthOfTest = seq1.length();
        int lengthOfRef = 1;

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSeq1, seq1);
        assertEquals(lengthOfTest, lengthOfRef);
    }

}