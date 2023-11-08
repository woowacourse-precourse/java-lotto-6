package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import lotto.constant.message.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationUtilTest {

    ValidationUtil validationUtil;

    @BeforeEach
    void init() {
        validationUtil = new ValidationUtil();
    }

    @Test
    @DisplayName("올바르지 않은 구매금액 입력시 예외 발생")
    void shouldThrowInvalidPurchaseInput() throws Exception {
        //given
        Method method = validationUtil.getClass().getDeclaredMethod("validateNumberType", String.class);
        method.setAccessible(true);

        //when
        String purchaseAmount = "천원";

        // then
        try {
            method.invoke(validationUtil, purchaseAmount);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.IS_NOT_NUMBER.getMessage());
        }
    }

    @Test
    @DisplayName("올바르지 않은 구매금액 입력시 예외 발생2")
    void shouldThrowInvalidPurchaseInputTwo() throws Exception {
        //given
        Method method = validationUtil.getClass().getDeclaredMethod("validateNumberType", String.class);
        method.setAccessible(true);

        //when
        String purchaseAmount = "1,000";

        // then
        try {
            method.invoke(validationUtil, purchaseAmount);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.IS_NOT_NUMBER.getMessage());
        }
    }

    @Test
    @DisplayName("빈칸이 포함된 잘못된 입력시 예외 발생")
    void shouldThrowBlankInput() throws Exception {
        //given
        Method method = validationUtil.getClass().getDeclaredMethod("validateBlank", List.class);
        method.setAccessible(true);

        //when
        List<String> numbers = List.of("1,2,3,4,5,6,,,");

        // then
        try {
            method.invoke(validationUtil, numbers);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.NUMBER_BLANK.getMessage());
        }
    }

    @Test
    @DisplayName("빈칸이 포함된 잘못된 입력시 예외 발생2")
    void shouldThrowBlankInputTwo() throws Exception {
        //given
        Method method = validationUtil.getClass().getDeclaredMethod("validateBlank", List.class);
        method.setAccessible(true);

        //when
        List<String> numbers = List.of("1,2,,,4,");

        // then
        try {
            method.invoke(validationUtil, numbers);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.NUMBER_BLANK.getMessage());
        }
    }

    @Test
    @DisplayName("6개가 아닌 숫자들을 입력시 예외 발생")
    void shouldThrowOverCountInput() throws Exception {
        //given
        Method method = validationUtil.getClass().getDeclaredMethod("validateCount", List.class);
        method.setAccessible(true);

        //when
        List<String> numbers = List.of("1,2,3,5,6,7,8");

        // then
        try {
            method.invoke(validationUtil, numbers);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.COUNT_ERROR.getMessage());
        }
    }

    @Test
    @DisplayName("입력받은 값들 중 숫자가 아닌 값을 입력시 예외 발생")
    void shouldThrowCannotMakeIntegerInput() throws Exception {
        //given
        Method method = validationUtil.getClass().getDeclaredMethod("StringToInteger", List.class);
        method.setAccessible(true);

        //when
        List<String> numbers = List.of("1,2,삼,4,열일곱,8");

        // then
        try {
            method.invoke(validationUtil, numbers);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(NumberFormatException.class)
                    .hasMessageContaining(ExceptionMessage.ERROR.getMessage());
        }
    }

    @Test
    @DisplayName("범위 외의 숫자들 입력시 예외 발생")
    void shouldThrowNotInRangeInput() throws Exception {
        //given
        Method method = validationUtil.getClass().getDeclaredMethod("StringToInteger", List.class);
        method.setAccessible(true);

        //when
        List<String> numbers = List.of("46,47,50,92,34,23");

        // then
        try {
            method.invoke(validationUtil, numbers);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(NumberFormatException.class)
                    .hasMessageContaining(ExceptionMessage.ERROR.getMessage());
        }
    }
}