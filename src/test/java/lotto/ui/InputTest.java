package lotto.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

    private Input input;

    @BeforeEach
    public void setUp() {
        input = new Input();
    }

    @Test
    @DisplayName("정수가 아닌 수를 입력했을 때, 예외가 발생한다.")
    public void testNotIntegerPurchasePrice() throws Exception {
        //given
        String inValidInput = "2001.1";

        //when
        Method method = Input.class.getDeclaredMethod("validPurchasePrice", String.class);
        method.setAccessible(true);

        //then
        assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, inValidInput);
        });
    }

    @Test
    @DisplayName("0보다 작은 수를 입력했을 때, 예외가 발생한다.")
    public void testLessThanZeroPurchasePrice() throws Exception {
        //given
        String inValidInput = "-1";

        //when
        Method method = Input.class.getDeclaredMethod("validPurchasePrice", String.class);
        method.setAccessible(true);

        //then
        assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, inValidInput);
        });
    }

    @Test
    @DisplayName("로또 금액으로 나누어지지 않은 금액을 입력했을 때, 예외가 발생한다.")
    public void testNotLottoPurchasePrice() throws Exception {
        //given
        String inValidInput = "100002";

        //when
        Method method = Input.class.getDeclaredMethod("validPurchasePrice", String.class);
        method.setAccessible(true);

        //then
        assertThrows(InvocationTargetException.class, () -> {
            method.invoke(input, inValidInput);
        });
    }

    @Test
    @DisplayName("String 형태의 정수 값을 int 변환에 성공한다.")
    public void testStringToInt() throws Exception {
        //given
        String validInput = "10000";
        int expectedResult = 10000;

        //when
        Method method = Input.class.getDeclaredMethod("StringToInt", String.class);
        method.setAccessible(true);
        Object result = method.invoke(input, validInput);

        //then
        assertEquals(expectedResult, result);
    }
}