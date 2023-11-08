package lotto.validator;

import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {

    @Test
    void validInputPurchaseAmountTest() {
        assertThat(InputValidator.validInputPurchaseAmount("8000")).isEqualTo("8000");
        assertThatThrownBy(() -> InputValidator.validInputPurchaseAmount("100")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validInputWinningNumbersTest() {
        assertThat(InputValidator.validInputWinningNumbers("1,2,3,4,5,6")).isEqualTo("1,2,3,4,5,6");
        assertThatThrownBy(() -> InputValidator.validInputWinningNumbers("1,2,3,4,5,5")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validInputBonusTest() {
        String input = "1,2,3,4,5,6";
        List<Integer> winningNumbers = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
        assertThat(InputValidator.validInputBonus(winningNumbers, "45")).isEqualTo("45");
        assertThatThrownBy(() -> InputValidator.validInputBonus(winningNumbers, "46")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.validInputBonus(winningNumbers, "1,45")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.validInputBonus(winningNumbers, "[1,45")).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void isNumberFormatTest() {
        assertThat(InputValidator.isNumberFormat("5600")).isEqualTo(true);
        assertThat(InputValidator.isNumberFormat("5600,1000")).isEqualTo(false);
        assertThat(InputValidator.isNumberFormat("")).isEqualTo(false);
    }

    @Test
    void isRangeTest() {
        assertThat(InputValidator.isRange("45")).isEqualTo(true);
        assertThat(InputValidator.isRange("46")).isEqualTo(false);
        assertThat(InputValidator.isRange("1")).isEqualTo(true);
        assertThat(InputValidator.isRange("0")).isEqualTo(false);
    }

    @Test
    void isUnitTest() {
        assertThat(InputValidator.isUnit("1000")).isEqualTo(true);
        assertThat(InputValidator.isUnit("00")).isEqualTo(false);
        assertThat(InputValidator.isUnit("1100")).isEqualTo(false);
    }

    @Test
    void isSixNumberTest() {
        assertThat(InputValidator.isSixNumber("1,2,3,4,5,6")).isEqualTo(true);
        assertThat(InputValidator.isSixNumber("1,2,3,4,5")).isEqualTo(false);
    }

    @Test
    void isWinningRangeTest() {
        assertThat(InputValidator.isWinningRange("1,2,3,4,5,45")).isEqualTo(true);
        assertThat(InputValidator.isWinningRange("l,2,3,4,5,46")).isEqualTo(false);
    }
}