package pl.pjwstk.lab3;

import pl.pjwstk.lab3.LolCalculator;
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
        Assert.assertEquals(9,result);
    }

    @Test
    public void testLolCalculator2() {
        int result = lolCalculator.LoLCalculator(20,1000);
        Assert.assertNotEquals(9,result);
    }

    @Test
    public void testLolCalculator3() {
        int result = lolCalculator.LoLCalculator(15,1000);
        int result2 = lolCalculator.LoLCalculator(15,2000);
        Assert.assertNotSame(result,result2);
    }

    @Test
    public void testLolCalculator4() {
        int result = lolCalculator.LoLCalculator(14, 1739);
        Assert.assertEquals(14, result);
    }

    @Test
    public void testLolCalculator5() {
        int result = lolCalculator.LoLCalculator(12, 1800);
        int result2 = lolCalculator.LoLCalculator(22, 1800);
        Assert.assertNotSame(result, result2);
    }

    @Test
    public void testJungleFullClear() {
        int result = lolCalculator.JungleCampGold("FullClear");
        Assert.assertEquals(610,result);
    }

    @Test
    public void testJungleNone() {
        int result = lolCalculator.JungleCampGold("None");
        Assert.assertEquals(0, result);
    }

    @Test
    public void testJungleTop() {
        int result = lolCalculator.JungleCampGold("Top");
        Assert.assertEquals(290, result);
    }

    @Test
    public void testJungleBot() {
        int result = lolCalculator.JungleCampGold("Bot");
        Assert.assertEquals(320, result);
    }

    @Test
    public void testJungleClearTypeNoData() {
        int result = lolCalculator.JungleCampGold("");
        int result2 = lolCalculator.JungleCampGold("None");
        Assert.assertNotSame(result, result2);
    }
}
