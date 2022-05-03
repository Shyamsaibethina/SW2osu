import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;

/**
 * JUnit test fixture for {@code Set<String>}'s constructor and kernel methods.
 *
 * @author Put your name here
 *
 */
public abstract class SetTest {

    /**
     * Invokes the appropriate {@code Set} constructor and returns the result.
     *
     * @return the new set
     * @ensures constructorTest = {}
     */
    protected abstract Set<String> constructorTest();

    /**
     * Invokes the appropriate {@code Set} constructor and returns the result.
     *
     * @return the new set
     * @ensures constructorRef = {}
     */
    protected abstract Set<String> constructorRef();

    /**
     * Creates and returns a {@code Set<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsTest = [entries in args]
     */
    private Set<String> createFromArgsTest(String... args) {
        Set<String> set = this.constructorTest();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    /**
     * Creates and returns a {@code Set<String>} of the reference implementation
     * type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsRef = [entries in args]
     */
    private Set<String> createFromArgsRef(String... args) {
        Set<String> set = this.constructorRef();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    /**
     * Routine Test case with set1 = <"2","4","6"> and addedOn = <"8">.
     */
    @Test
    public void test1() {
        /*
         * Set up variables and call method under test
         */
        Set<String> set1 = this.createFromArgsTest("2", "4", "6");
        Set<String> expectedSet1 = this.createFromArgsRef("2", "4", "6", "8");
        String addedOn = "8";
        set1.add(addedOn);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSet1, set1);
    }

    /**
     * Boundary Test case with set1 = <> and addedOn = "1".
     */
    @Test
    public void test2() {
        /*
         * Set up variables and call method under test
         */
        Set<String> set1 = this.createFromArgsTest();
        Set<String> expectedSet1 = this.createFromArgsRef("1");
        String addedOn = "1";
        set1.add(addedOn);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSet1, set1);
    }

    /**
     * Challenging Test case with set1 = <"1","2","3"> and addedOn = "".
     */
    @Test
    public void test3() {
        /*
         * Set up variables and call method under test
         */
        Set<String> set1 = this.createFromArgsTest("1", "2", "3");
        Set<String> expectedSet1 = this.createFromArgsRef("1", "2", "3", "");
        String addedOn = "";
        set1.add(addedOn);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSet1, set1);
    }

    /**
     * Routine Test case with set1 = <"1","2","3">.
     */
    @Test
    public void test4() {
        /*
         * Set up variables and call method under test
         */
        Set<String> set1 = this.createFromArgsTest("1", "2", "3");
        Set<String> expectedSet1 = this.createFromArgsRef("1", "2");

        set1.remove("3");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSet1, set1);
    }

    /**
     * Boundary Test case with set1 = <"1">.
     */
    @Test
    public void test5() {
        /*
         * Set up variables and call method under test
         */
        Set<String> set1 = this.createFromArgsTest("1");
        Set<String> expectedSet1 = this.createFromArgsRef();

        set1.remove("1");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSet1, set1);
    }

    /**
     * Challenging Test case with set1 = <"1","2","3">.
     */
    @Test
    public void test6() {
        /*
         * Set up variables and call method under test
         */
        Set<String> set1 = this.createFromArgsTest("");
        Set<String> expectedSet1 = this.createFromArgsRef();

        set1.remove("");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSet1, set1);
    }

    /**
     * Routine Test case with set1 = <"1","2","3">.
     */
    @Test
    public void test7() {
        /*
         * Set up variables and call method under test
         */
        Set<String> set1 = this.createFromArgsTest("1", "2", "3");
        Set<String> expectedSet1 = this.createFromArgsRef("1", "2", "3");
        int lengthOfTest = set1.size();
        int lengthOfRef = 3;

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSet1, set1);
        assertEquals(lengthOfTest, lengthOfRef);
    }

    /**
     * Boundary Test case with set1 = <>.
     */
    @Test
    public void test8() {
        /*
         * Set up variables and call method under test
         */
        Set<String> set1 = this.createFromArgsTest();
        Set<String> expectedSet1 = this.createFromArgsRef();
        int lengthOfTest = set1.size();
        int lengthOfRef = 0;

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSet1, set1);
        assertEquals(lengthOfTest, lengthOfRef);
    }

    /**
     * Challenging Test case with set1 = <"">.
     */
    @Test
    public void test9() {
        /*
         * Set up variables and call method under test
         */
        Set<String> set1 = this.createFromArgsTest("");
        Set<String> expectedSet1 = this.createFromArgsRef("");
        int lengthOfTest = set1.size();
        int lengthOfRef = 1;

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSet1, set1);
        assertEquals(lengthOfTest, lengthOfRef);
    }

    /**
     * Routine Test case with set1 = <"1","2","3"> and test = "2"
     */
    @Test
    public void test10() {
        /*
         * Set up variables and call method under test
         */
        Set<String> set1 = this.createFromArgsTest("1", "2", "3");
        Set<String> expectedSet1 = this.createFromArgsRef("1", "2", "3");
        String test = "2";
        boolean containsOfTest = set1.contains(test);
        boolean containsOfRef = true;

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSet1, set1);
        assertEquals(containsOfTest, containsOfRef);
    }

    /**
     * Boundary Test case with set1 = <> and test = "2"
     */
    @Test
    public void test11() {
        /*
         * Set up variables and call method under test
         */
        Set<String> set1 = this.createFromArgsTest();
        Set<String> expectedSet1 = this.createFromArgsRef();
        String test = "2";
        boolean containsOfTest = set1.contains(test);
        boolean containsOfRef = false;

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSet1, set1);
        assertEquals(containsOfTest, containsOfRef);
    }

    /**
     * Challenging Test case with set1 = <""> and test = ""
     */
    @Test
    public void test12() {
        /*
         * Set up variables and call method under test
         */
        Set<String> set1 = this.createFromArgsTest("");
        Set<String> expectedSet1 = this.createFromArgsRef("");
        String test = "";
        boolean containsOfTest = set1.contains(test);
        boolean containsOfRef = true;

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(expectedSet1, set1);
        assertEquals(containsOfTest, containsOfRef);
    }

    /**
     * Routine Test case with set1 = <"1","2","3">
     */
    @Test
    public void test13() {
        /*
         * Set up variables and call method under test
         */
        //Setup
        Set<String> set1 = this.createFromArgsTest("1", "2", "3");
        Set<String> expectedSet1 = this.createFromArgsRef("1", "2", "3");

        //Call
        String capture = set1.removeAny();

        //Evaluation
        assertEquals(true, expectedSet1.contains(capture));
        expectedSet1.remove(capture);
        assertEquals(expectedSet1, set1);
    }

    /**
     * Boundary Test case with set1 = <"1">
     */
    @Test
    public void test14() {
        /*
         * Set up variables and call method under test
         */
        //Setup
        Set<String> set1 = this.createFromArgsTest("1");
        Set<String> expectedSet1 = this.createFromArgsRef("1");

        //Call
        String capture = set1.removeAny();

        //Evaluation
        assertEquals(true, expectedSet1.contains(capture));
        expectedSet1.remove(capture);
        assertEquals(expectedSet1, set1);
    }

    /**
     * Challenging Test case with set1 = <"1">
     */
    @Test
    public void test15() {
        /*
         * Set up variables and call method under test
         */
        //Setup
        Set<String> set1 = this.createFromArgsTest("");
        Set<String> expectedSet1 = this.createFromArgsRef("");

        //Call
        String capture = set1.removeAny();

        //Evaluation
        assertEquals(true, expectedSet1.contains(capture));
        expectedSet1.remove(capture);
        assertEquals(expectedSet1, set1);
    }

}
