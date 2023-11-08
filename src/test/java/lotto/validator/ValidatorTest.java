package lotto.validator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
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
    void isPositiveMultiplesOfThousand_1000원_단위가_아닌_숫자_검사() {
        int input1 = -1200;
        int input2 = 5800;
        assertFalse(validator.isPositiveMultiplesOfThousand(input1));
        assertFalse(validator.isPositiveMultiplesOfThousand(input2));
    }

    @DisplayName("중복된 당첨번호가 있을 경우 true를 반환한다.")
    @Test
    void containsDuplicatedNumbers_중복된_당첨번호_검사() {
        List<Integer> winningNumbers = List.of(1,2,2,4,5,6);
        assertTrue(validator.containsDuplicatedNumbers(winningNumbers));
    }

    @DisplayName("당첨번호가 6개가 아닐 경우 false를 반환한다.")
    @Test
    void checkNumbersSize_당첨번호_개수_검사() {
        List<Integer> winningNumbers1 = List.of(1,2,3,4,5);
        List<Integer> winningNumbers2 = List.of(1,2,3,4,5,6,7);
        assertFalse(validator.checkNumbersSize(winningNumbers1));
        assertFalse(validator.checkNumbersSize(winningNumbers2));
    }

    @DisplayName("당첨번호가 1이상 45이하의 숫자가 아니라면 false를 반환한다.")
    @Test
    void checkRangeValidity_당첨번호_범위_검사() {
        List<Integer> winningNumbers1 = List.of(0,2,3,4,5);
        List<Integer> winningNumbers2 = List.of(1,2,3,50,5);
        assertFalse(validator.checkRangeValidity(winningNumbers1));
        assertFalse(validator.checkRangeValidity(winningNumbers2));
    }
}