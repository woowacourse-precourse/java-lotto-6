package lotto.global;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidationTest {
    private InputValidation inputValidation;

    @BeforeEach
    public void setUp() {
        inputValidation = new InputValidation();
    }

    @Test
    @DisplayName("정수가 아닌 수를 입력했을 때, 예외가 발생한다.")
    public void testNotIntegerPurchasePrice() throws Exception {
        //given
        String inValidInput = "2001.1";

        //when
        Method method = InputValidation.class.getDeclaredMethod("validPurchasePrice", String.class);
        method.setAccessible(true);

        //then
        assertThrows(InvocationTargetException.class, () -> {
            method.invoke(inputValidation, inValidInput);
        });
    }

    @Test
    @DisplayName("0보다 작은 수를 입력했을 때, 예외가 발생한다.")
    public void testLessThanZeroPurchasePrice() throws Exception {
        //given
        String inValidInput = "-1";

        //when
        Method method = InputValidation.class.getDeclaredMethod("validPurchasePrice", String.class);
        method.setAccessible(true);

        //then
        assertThrows(InvocationTargetException.class, () -> {
            method.invoke(inputValidation, inValidInput);
        });
    }

    @Test
    @DisplayName("로또 금액으로 나누어지지 않은 금액을 입력했을 때, 예외가 발생한다.")
    public void testNotLottoPurchasePrice() throws Exception {
        //given
        String inValidInput = "100002";

        //when
        Method method = InputValidation.class.getDeclaredMethod("validPurchasePrice", String.class);
        method.setAccessible(true);

        //then
        assertThrows(InvocationTargetException.class, () -> {
            method.invoke(inputValidation, inValidInput);
        });
    }

    @Test
    @DisplayName("String 형태의 정수 값을 int 변환에 성공한다.")
    public void testStringToInt() throws Exception {
        //given
        String validInput = "10000";
        int expectedResult = 10000;

        //when
        Method method = InputValidation.class.getDeclaredMethod("StringToInt", String.class);
        method.setAccessible(true);
        Object result = method.invoke(inputValidation, validInput);

        //then
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("기존 로또의 개수보다 많은 개수를 입력할 경우, 예외가 발생한다.")
    public void testMoreThanLottoSize() throws Exception {
        // given
        List<Integer> invalidInput = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // when
        Method method = InputValidation.class.getDeclaredMethod("checkNumberSize", List.class);
        method.setAccessible(true);

        //then
        assertThrows(InvocationTargetException.class, () -> {
            method.invoke(inputValidation, invalidInput);
        });
    }

    @Test
    @DisplayName("기존 로또의 개수보다 적은 개수를 입력할 경우, 예외가 발생한다.")
    public void testLessThanLottoSize() throws Exception {
        // given
        List<Integer> invalidInput = Arrays.asList(1, 2, 3, 4, 5);

        // when
        Method method = InputValidation.class.getDeclaredMethod("checkNumberSize", List.class);
        method.setAccessible(true);

        //then
        assertThrows(InvocationTargetException.class, () -> {
            method.invoke(inputValidation, invalidInput);
        });
    }

    @Test
    @DisplayName("주어진 수가 로또 수 범위보다 클 경우, 예외가 발생한다.")
    public void testBiggerOutOfRange() throws Exception {
        // given
        int invalidNumber = 46;

        // when
        Method method = InputValidation.class.getDeclaredMethod("checkInRange", int.class);
        method.setAccessible(true);

        //then
        assertThrows(InvocationTargetException.class, () -> {
            method.invoke(inputValidation, invalidNumber);
        });
    }

    @Test
    @DisplayName("주어진 수가 로또 수 범위보다 작을 경우, 예외가 발생한다.")
    public void testLessOutOfRange() throws Exception {
        // given
        int invalidNumber = 0;

        // when
        Method method = InputValidation.class.getDeclaredMethod("checkInRange", int.class);
        method.setAccessible(true);

        //then
        assertThrows(InvocationTargetException.class, () -> {
            method.invoke(inputValidation, invalidNumber);
        });
    }

    @Test
    @DisplayName("보너스 수가 정수 형태가 아닐 경우, 예외가 발생한다.")
    public void testBonusNotInteger() throws Exception {
        // given
        String invalidNumber = "43.4";

        // when
        Method method = InputValidation.class.getDeclaredMethod("validBonusNumber", String.class);
        method.setAccessible(true);

        //then
        assertThrows(InvocationTargetException.class, () -> {
            method.invoke(inputValidation, invalidNumber);
        });
    }

    @Test
    @DisplayName("보너스 수가 로또 수 범위보다 클 경우, 예외가 발생한다.")
    public void testBonusBiggerOutOfRange() throws Exception {
        // given
        String invalidNumber = "46";

        // when
        Method method = InputValidation.class.getDeclaredMethod("validBonusNumber", String.class);
        method.setAccessible(true);

        //then
        assertThrows(InvocationTargetException.class, () -> {
            method.invoke(inputValidation, invalidNumber);
        });
    }

    @Test
    @DisplayName("보너스 수가 로또 수 범위보다 작을 경우, 예외가 발생한다.")
    public void testBonusLessOutOfRange() throws Exception {
        // given
        String invalidNumber = "0";

        // when
        Method method = InputValidation.class.getDeclaredMethod("validBonusNumber", String.class);
        method.setAccessible(true);

        //then
        assertThrows(InvocationTargetException.class, () -> {
            method.invoke(inputValidation, invalidNumber);
        });
    }
}