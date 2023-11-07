package lotto.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    private final Validator validator = new Validator();

    @DisplayName("로또 구입 금액에 숫자가 아닌 문자가 포함되면 true를 반환한다.")
    @Test
    void containsNonNumericCharacters_숫자가_아닌_문자_포함_검사() {
        String input = "10000원";
        assertTrue(validator.containsNonNumericCharacters(input));
    }

    @DisplayName("로또 구입 금액이 1,000원 단위가 아닐 경우 false를 반환한다.")
    @Test
    void isMultiplesOfThousand_1000원_단위가_아닌_숫자_검사() {
        int input = -1200;
        assertFalse(validator.isPositiveMultiplesOfThousand(input));
    }
}