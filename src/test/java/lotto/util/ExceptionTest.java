package lotto.util;


import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExceptionTest {

    private Exception exception;

    @BeforeEach
    void setUp() {
        exception = new Exception();
    }

    @Test
    void 유저가_입력한_지불_금액이_올바른_입력인지_테스트() {
        String inputAmount1 = "8000";
        String inputAmount2 = "100000";
        String inputAmount3 = "0";
        String inputAmount4 = "80a0";
        String inputAmount5 = " 8000";
        String inputAmount6 = "80 00";

        Assertions.assertDoesNotThrow(() -> {
            exception.checkInvalidNumber(inputAmount1);
        });
        Assertions.assertDoesNotThrow(() -> {
            exception.checkInvalidNumber(inputAmount2);
        });
        Assertions.assertDoesNotThrow(() -> {
            exception.checkInvalidNumber(inputAmount3);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            exception.checkInvalidNumber(inputAmount4);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            exception.checkInvalidNumber(inputAmount5);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            exception.checkInvalidNumber(inputAmount6);
        });
    }

    @Test
    void 지불금액이_1000원_단위인지_테스트() {
        int inputAmount1 = 8000;
        int inputAmount2 = 111000;
        int inputAmount3 = 1000;
        int inputAmount4 = 2200;
        int inputAmount5 = 1001;
        int inputAmount6 = 1100;

        Assertions.assertDoesNotThrow(() -> {
            exception.checkUnitPaymentAmount(inputAmount1);
        });
        Assertions.assertDoesNotThrow(() -> {
            exception.checkUnitPaymentAmount(inputAmount2);
        });
        Assertions.assertDoesNotThrow(() -> {
            exception.checkUnitPaymentAmount(inputAmount3);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            exception.checkUnitPaymentAmount(inputAmount4);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            exception.checkUnitPaymentAmount(inputAmount5);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            exception.checkUnitPaymentAmount(inputAmount6);
        });
    }

    @Test
    void 지불금액이_1000_아래인지_확인하는_테스트() {
        int inputAmount1 = 1000;
        int inputAmount2 = 2000;
        int inputAmount3 = 1000000;
        int inputAmount4 = 0;
        int inputAmount5 = 900;
        int inputAmount6 = -1000;
        Assertions.assertDoesNotThrow(() -> {
            exception.checkRangePaymentAmount(inputAmount1);
        });
        Assertions.assertDoesNotThrow(() -> {
            exception.checkRangePaymentAmount(inputAmount2);
        });
        Assertions.assertDoesNotThrow(() -> {
            exception.checkRangePaymentAmount(inputAmount3);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            exception.checkRangePaymentAmount(inputAmount4);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            exception.checkRangePaymentAmount(inputAmount5);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            exception.checkRangePaymentAmount(inputAmount6);
        });
    }

    @Test
    void 입력한_당첨번호_마지막_글자_테스트() {
        String input1 = "1,2,3,4,5,6";
        String input2 = "1,2,3,4,5,6,";

        Assertions.assertDoesNotThrow(() -> {
            Exception.checkLastComma(input1);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Exception.checkLastComma(input2);
        });
    }

    @Test
    void 로또번호_중복_테스트() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(1, 2, 2, 4, 5, 6);
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 5, 5, 6);

        Assertions.assertDoesNotThrow(() -> {
            Exception.checkDuplicationNumber(numbers1);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Exception.checkDuplicationNumber(numbers2);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Exception.checkDuplicationNumber(numbers3);
        });
    }

    @Test
    void 로또번호_범위_테스트() {
        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5,6);
        List<Integer> numbers2 = Arrays.asList(1,2,3,4,5,45);
        List<Integer> numbers3 = Arrays.asList(1,10,20,30,40,45);
        List<Integer> numbers4 = Arrays.asList(0,2,3,4,5,6);
        List<Integer> numbers5 = Arrays.asList(1,2,3,4,5,46);
        List<Integer> numbers6 = Arrays.asList(1,2,3,-1,5,6);

        Assertions.assertDoesNotThrow(() -> {
            Exception.checkRangeLottoNumber(numbers1);
        });
        Assertions.assertDoesNotThrow(() -> {
            Exception.checkRangeLottoNumber(numbers2);
        });
        Assertions.assertDoesNotThrow(() -> {
            Exception.checkRangeLottoNumber(numbers3);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Exception.checkRangeLottoNumber(numbers4);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Exception.checkRangeLottoNumber(numbers5);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Exception.checkRangeLottoNumber(numbers6);
        });
    }
}