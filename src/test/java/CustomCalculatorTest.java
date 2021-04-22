import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator;

    // 더하기 테스트를 진행합니다.
    @Test
    public void addTest() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.add(10,10);
        /* 테스트 코드 입력 */
        assertTrue(result == 20);
        //assertFalse(result == 20);
    }

    @Test
    public void subTest() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(20,10);
        /* 테스트 코드 입력 */
        assertTrue(result == 10);
    }

    @Test
    public void mulTest() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(2, 5);
        assertTrue(result == 10);
    }

    @Test
    public void divTest() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(20, 4);
        assertTrue(result == 5);
    }


}