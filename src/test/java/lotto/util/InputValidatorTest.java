package lotto.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void 로또_번호_개수가_6개가_아닌_예외_테스트() {
        // given
        String[] split = {"1", "2", "3", "4", "5"};
        String[] split2 = {"1", "2", "3", "4", "5", "6", "7"};
        String[] split3 = {"1"};

        // when
        boolean validationResult1 = InputValidator.isValidSplitSize(split);
        boolean validationResult2 = InputValidator.isValidSplitSize(split2);
        boolean validationResult3 = InputValidator.isValidSplitSize(split3);

        // then
        Assertions.assertFalse(validationResult1);
        Assertions.assertFalse(validationResult2);
        Assertions.assertFalse(validationResult3);
    }

    @Test
    void 로또_번호가_범위를_벗어난_예외_테스트() {
        // given
        int testNum = -1;
        int testNum2 = 46;
        int testNum3 = 1000;

        // when
        boolean result1 = InputValidator.isInRange(testNum);
        boolean result2 = InputValidator.isInRange(testNum2);
        boolean result3 = InputValidator.isInRange(testNum3);

        // then
        Assertions.assertFalse(result1);
        Assertions.assertFalse(result2);
        Assertions.assertFalse(result3);
    }

    @Test
    void 구매_금액이_1000원_단위로_나누어떨어지지_않는_예외_테스트() {
        // given
        int testNum = 1001;
        int testNum2 = 123456;

        // when
        boolean result1 = InputValidator.isDividedInto1000(testNum);
        boolean result2 = InputValidator.isDividedInto1000(testNum2);

        // then
        Assertions.assertFalse(result1);
        Assertions.assertFalse(result2);
    }

    @Test
    void 구매_금액이_양수가_아닌_예외_테스트() {
        // given
        int testNum = 0;
        int testNum2 = -1000;

        // when
        boolean result1 = InputValidator.isPositive(testNum);
        boolean result2 = InputValidator.isPositive(testNum2);

        // then
        Assertions.assertFalse(result1);
        Assertions.assertFalse(result2);
    }

    @Test
    void 구매_금액이_숫자가_아닌_예외_테스트() {
        // given
        String testInput1 = "abcd";

        // when
        boolean result = InputValidator.isNumber(testInput1);

        // then
        Assertions.assertFalse(result);
    }
}