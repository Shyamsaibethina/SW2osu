import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;

/**
 * JUnit test fixture for {@code Map<String, String>}'s constructor and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class MapTest {

    /**
     * Invokes the appropriate {@code Map} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new map
     * @ensures constructorTest = {}
     */
    protected abstract Map<String, String> constructorTest();

    /**
     * Invokes the appropriate {@code Map} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new map
     * @ensures constructorRef = {}
     */
    protected abstract Map<String, String> constructorRef();

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the implementation
     * under test type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsTest = [pairs in args]
     */
    private Map<String, String> createFromArgsTest(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        Map<String, String> map = this.constructorTest();
        for (int i = 0; i < args.length; i += 2) {
            assert !map.hasKey(args[i]) : ""
                    + "Violation of: the 'key' entries in args are unique";
            map.add(args[i], args[i + 1]);
        }
        return map;
    }

    /**
     *
     * Creates and returns a {@code Map<String, String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the (key, value) pairs for the map
     * @return the constructed map
     * @requires <pre>
     * [args.length is even]  and
     * [the 'key' entries in args are unique]
     * </pre>
     * @ensures createFromArgsRef = [pairs in args]
     */
    private Map<String, String> createFromArgsRef(String... args) {
        assert args.length % 2 == 0 : "Violation of: args.length is even";
        Map<String, String> map = this.constructorRef();
        for (int i = 0; i < args.length; i += 2) {
            assert !map.hasKey(args[i]) : ""
                    + "Violation of: the 'key' entries in args are unique";
            map.add(args[i], args[i + 1]);
        }
        return map;
    }

    /**
     * Boundary Test case with map1 = <>
     */
    @Test
    public void test1() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> map1 = this.createFromArgsTest();
        Map<String, String> expectedMap1 = this.createFromArgsRef();

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
    }

    /**
     * Routine Test case with map1 = <"Hello","Bye">
     */
    @Test
    public void test2() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> map1 = this.createFromArgsTest("Hello", "Bye");
        Map<String, String> expectedMap1 = this.createFromArgsRef("Hello",
                "Bye");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
    }

    /**
     * Challenging Test case with map1 = <"Hello, "">
     */
    @Test
    public void test3() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> map1 = this.createFromArgsTest("Hello", "");
        Map<String, String> expectedMap1 = this.createFromArgsRef("Hello", "");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
    }

    /**
     * Boundary Test case with map1 = <>, addedOn = <"hello"> and <"bye">
     */
    @Test
    public void test4() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> map1 = this.createFromArgsTest();
        Map<String, String> expectedMap1 = this.createFromArgsRef("hello",
                "bye");
        String addedOnKey = "hello";
        String addedOnValue = "bye";
        map1.add(addedOnKey, addedOnValue);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
    }

    /**
     * Routine Test case with map1 = <"Good","Luck">, addedOn = <"hello"> and
     * <"bye">
     */
    @Test
    public void test5() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> map1 = this.createFromArgsTest("Good", "Luck");
        Map<String, String> expectedMap1 = this.createFromArgsRef("Good",
                "Luck", "hello", "bye");
        String addedOnKey = "hello";
        String addedOnValue = "bye";
        map1.add(addedOnKey, addedOnValue);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
    }

    /**
     * Challenging Test case with map1 = <"Good","Luck">, addedOn = <"Bad"> and
     * <"Luck">
     */
    @Test
    public void test6() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> map1 = this.createFromArgsTest("Good", "Luck");
        Map<String, String> expectedMap1 = this.createFromArgsRef("Good",
                "Luck", "Bad", "Luck");
        String addedOnKey = "Bad";
        String addedOnValue = "Luck";
        map1.add(addedOnKey, addedOnValue);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
    }

    /**
     * Boundary Test case with map1 = <"Good","Luck">
     */
    @Test
    public void test7() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> map1 = this.createFromArgsTest("Good", "Luck");
        Map<String, String> expectedMap1 = this.createFromArgsRef();
        map1.remove("Good");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
    }

    /**
     * Routine Test case with map1 = <"Good","Luck", "Bad", "Luck">
     */
    @Test
    public void test8() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> map1 = this.createFromArgsTest("Good", "Luck",
                "Bad", "Luck");
        Map<String, String> expectedMap1 = this.createFromArgsRef("Bad",
                "Luck");
        map1.remove("Good");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
    }

    /**
     * Challenging Test case with map1 = <"Good","Luck", "", "Luck">
     */
    @Test
    public void test9() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> map1 = this.createFromArgsTest("Good", "Luck", "",
                "Luck");
        Map<String, String> expectedMap1 = this.createFromArgsRef("Good",
                "Luck");
        map1.remove("");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
    }

    /**
     * Boundary Test case with map1 = <"","">
     */
    @Test
    public void test10() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> map1 = this.createFromArgsTest("", "");
        Map<String, String> expectedMap1 = this.createFromArgsRef("", "");
        String value = map1.value("");
        String expectedValue = "";

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
        assertEquals(value, expectedValue);
    }

    /**
     * Routine Test case with map1 = <"Good","Luck">
     */
    @Test
    public void test11() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> map1 = this.createFromArgsTest("Good", "Luck");
        Map<String, String> expectedMap1 = this.createFromArgsRef("Good",
                "Luck");
        String value = map1.value("Good");
        String expectedValue = "Luck";

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
        assertEquals(value, expectedValue);
    }

    /**
     * Challenging Test case with map1 = <"Good","">
     */
    @Test
    public void test12() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> map1 = this.createFromArgsTest("Good", "");
        Map<String, String> expectedMap1 = this.createFromArgsRef("Good", "");
        String value = map1.value("Good");
        String expectedValue = "";

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
        assertEquals(value, expectedValue);
    }

    /**
     * Boundary Test case with map1 = <"","">
     */
    @Test
    public void test13() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> map1 = this.createFromArgsTest("", "");
        Map<String, String> expectedMap1 = this.createFromArgsRef("", "");
        Boolean value = map1.hasKey("");
        Boolean expectedValue = true;

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
        assertEquals(value, expectedValue);
    }

    /**
     * Routine Test case with map1 = <"Good","Luck">
     */
    @Test
    public void test14() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> map1 = this.createFromArgsTest("Good", "Luck");
        Map<String, String> expectedMap1 = this.createFromArgsRef("Good",
                "Luck");
        Boolean value = map1.hasKey("Good");
        Boolean expectedValue = true;

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
        assertEquals(value, expectedValue);
    }

    /**
     * Challenging Test case with map1 = <"Good","Luck">
     */
    @Test
    public void test15() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> map1 = this.createFromArgsTest("Good", "Luck");
        Map<String, String> expectedMap1 = this.createFromArgsRef("Good",
                "Luck");
        Boolean value = map1.hasKey("Bad");
        Boolean expectedValue = false;

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
        assertEquals(value, expectedValue);
    }

    /**
     * Boundary Test case with map1 = <>
     */
    @Test
    public void test16() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> map1 = this.createFromArgsTest();
        Map<String, String> expectedMap1 = this.createFromArgsRef();
        int value = map1.size();
        int expectedValue = 0;

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
        assertEquals(value, expectedValue);
    }

    /**
     * Routine Test case with map1 = <"Bad","Luck">
     */
    @Test
    public void test17() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> map1 = this.createFromArgsTest("Bad", "Luck");
        Map<String, String> expectedMap1 = this.createFromArgsRef("Bad",
                "Luck");
        int value = map1.size();
        int expectedValue = 1;

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
        assertEquals(value, expectedValue);
    }

    /**
     * Challenging Test case with map1 = <"","">
     */
    @Test
    public void test18() {
        /*
         * Set up variables and call method under test
         */
        Map<String, String> map1 = this.createFromArgsTest("", "");
        Map<String, String> expectedMap1 = this.createFromArgsRef("", "");
        int value = map1.size();
        int expectedValue = 1;

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
        assertEquals(value, expectedValue);
    }

    /**
     * Boundary Test case with map1 = <"l","">
     */
    @Test
    public void test19() {
        /*
         * Set up variables and call method under test
         */
        //Setup
        Map<String, String> map1 = this.createFromArgsTest("l", "");
        Map<String, String> expectedMap1 = this.createFromArgsRef("l", "");

        //Call
        Map.Pair<String, String> capture = map1.removeAny();

        //Evaluation
        assertEquals(true, expectedMap1.hasKey("l"));
        expectedMap1.remove("l");
        assertEquals(map1, expectedMap1);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
    }

    /**
     * Routine Test case with map1 = <"Good","Luck", "Bad", "Luck">
     */
    @Test
    public void test20() {
        /*
         * Set up variables and call method under test
         */
        //Setup
        Map<String, String> map1 = this.createFromArgsTest("Good", "Luck",
                "Bad", "Luck");
        Map<String, String> expectedMap1 = this.createFromArgsRef("Good",
                "Luck", "Bad", "Luck");

        //Call
        Map.Pair<String, String> capture = map1.removeAny();

        //Evaluation
        assertEquals(true, expectedMap1.hasKey(capture.key()));
        expectedMap1.remove(capture.key());
        assertEquals(map1, expectedMap1);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
    }

    /**
     * Challenging Test case with map1 = <"Good","Luck", "","Luck">
     */
    @Test
    public void test21() {
        /*
         * Set up variables and call method under test
         */
        //Setup
        Map<String, String> map1 = this.createFromArgsTest("Good", "Luck", "",
                "Luck");
        Map<String, String> expectedMap1 = this.createFromArgsRef("Good",
                "Luck", "", "Luck");

        //Call
        Map.Pair<String, String> capture = map1.removeAny();

        //Evaluation
        assertEquals(true, expectedMap1.hasKey(capture.key()));
        expectedMap1.remove(capture.key());
        assertEquals(map1, expectedMap1);

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(map1, expectedMap1);
    }

}
