package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class ValidationTest {
    @Test
    void validateAmountTest() {
        assertThatThrownBy(() -> Validation.validateAmount(12800))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isAllValidNumbersTestByOutOfRange() {
        assertThatThrownBy(() -> Validation.isAllValidNumbers(new ArrayList<>(List.of("1", "2", "3", "4", "5", "60"))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isAllValidNumbersTestByNotNumeric() {
        assertThatThrownBy(() -> Validation.isAllValidNumbers(new ArrayList<>(List.of("1j", "2", "3", "4", "5", "6"))))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    void validateNumberRange() {
        assertThatThrownBy(() -> Validation.validateAmount(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumberByDuplication() {
        assertThatThrownBy(() -> Validation.validateBonusNumber(1, new ArrayList<>(List.of("1", "2", "3", "4", "5", "6"))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBonusNumberByOutOfRange() {
        assertThatThrownBy(() -> Validation.validateBonusNumber(46, new ArrayList<>(List.of("1", "2", "3", "4", "5", "6"))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}