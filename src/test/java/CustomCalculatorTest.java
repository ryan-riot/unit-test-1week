
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.*;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator;

    //더하기 테스트 작성
    @Test
    public void add() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.add(10,15);
        int result2 = customCalculator.add(11, 16);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertTrue(result == 25);
        assertThat(result, is(25));
        System.out.println("result :: " + result);

        assertTrue(result2 == 27);
        assertThat(result2, is(27));
        System.out.println("result2 :: " + result2);
    }

    //빼기 테스트 작성
    @Test
    public void subtract() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(23,10);
        int result2 = customCalculator.subtract(20,10);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertTrue(result == 13);
        assertFalse(result == 12);
        System.out.println("result :: " + result);

        assertTrue(result2 == 10);
        assertFalse(result2 == 12);
        System.out.println("result2 :: " + result2);
    }

    @Test
    public void 뺴기테스트(){
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(23,10);
        int result2 = customCalculator.subtract(20,5);
        assertFalse(result == 12);
        assertFalse(result == 14);
    }

    //곱하기 테스트 작성
    @Test
    public void multiply() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(5,9);
        int result2 = customCalculator.multiply(4,10);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertTrue(result == 45);
        System.out.println("result :: " + result);

        assertTrue(result2 == 40);
        System.out.println("result2 :: " + result2);
    }

    //나누기 테스트 작성
    @Test
    public void divide() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(25,5);
        int result2 = customCalculator.divide(20,4);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertTrue(result == 5);
        assertFalse(result == 4);
        System.out.println("result :: " + result);

        assertTrue(result == 5);
        assertFalse(result == 4);
        System.out.println("result :: " + result);


    }

    @Test(timeout = 4000)
    public void timeInMethodTest() throws InterruptedException{
        Thread.sleep(3000);
    }

    @Test(timeout = 3000)
    public void 시간제한체크() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsEmptyIndexOutOfBoundException() {
        new ArrayList<Object>().get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void tesetIsEmptyOutOfBoundException() {
        new ArrayList<Object>().get(0);
    }

    @Test
    public void isEmptyArray() {
        ArrayList<Object> myList = new ArrayList<>();
        assertThat(myList, is(empty()));
    }

}