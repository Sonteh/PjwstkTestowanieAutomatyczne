package app;

import app.LolCalculator;
import org.junit.*;

import static org.junit.Assert.*;

public class LolCalculatorTest {
    private LolCalculator lolCalculator;

    @Before
    public void setUp() {
        lolCalculator = new LolCalculator();
//        System.out.println("Before");
    }

    @After
    public void tearDown() {
        lolCalculator = null;
//        System.out.println("After");
    }

    @Test
    public void testLolCalculator() {
        int result = lolCalculator.LoLCalculator(10,1000);
        assertEquals(9,result);
//        System.out.println("Test 1");
    }

    @Test
    public void testLolCalculator2() {
        int result = lolCalculator.LoLCalculator(20,1000);
        assertEquals(15,result);
//        System.out.println("Test 2");
    }

    @Test
    public void testLolCalculator3() {
        int result = lolCalculator.LoLCalculator(30,1000);
        assertEquals(25,result);
//        System.out.println("Test 3");
    }
}
