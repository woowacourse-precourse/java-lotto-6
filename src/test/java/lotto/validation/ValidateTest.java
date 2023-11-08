package lotto.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import lotto.utils.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateTest {

    @DisplayName("구입 금액 유효성 검증 테스트")
    @Test
    void 로또_구입_금액_테스트() {
        List<String> validMoneyList = Arrays.asList("1000", "2000"); // 유효한 금액 리스트
        for (String money : validMoneyList) {
            assertDoesNotThrow(() -> Validator.validateMoney(money));
        }

        List<String> invalidMoneyList = Arrays.asList("200", "1000j", "1500"); // 유효하지 않은 금액 리스트
        for (String money : invalidMoneyList) {
            assertThrows(IllegalArgumentException.class, () -> Validator.validateMoney(money));
        }
    }

    @DisplayName("당첨 번호가 중복되지 않는지 테스트")
    @Test
    void 당첨_번호_중복_테스트() {
        List<Integer> number1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> number2 = Arrays.asList(1, 2, 3, 3, 4, 5);

        assertDoesNotThrow(() -> Validator.validateWinningNumber(number1));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateWinningNumber(number2));
    }

    @DisplayName("당첨 번호 6개를 입력했는지 테스트")
    @Test
    void 당첨_번호_개수_테스트() {
        List<Integer> number1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> number2 = Arrays.asList(1, 2, 3, 3);

        assertDoesNotThrow(() -> Validator.validateWinningNumber(number1));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateWinningNumber(number2));
    }

    @DisplayName("당첨 번호 범위가 1부터 45 사이인지 테스트")
    @Test
    void 당첨_번호_범위_테스트() {
        List<Integer> number1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> number2 = Arrays.asList(51, 56, 50, 60, 65, 70);

        assertDoesNotThrow(() -> Validator.validateWinningNumber(number1));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateWinningNumber(number2));
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되는지 검증 테스트")
    @Test
    void 보너스_번호_중복_테스트() {
        List<Integer> number1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        String bonusNumber1 = "7";
        String bonusNumber2 = "5";

        assertDoesNotThrow(() -> Validator.validateBonusNumber(number1, bonusNumber1));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateBonusNumber(number1, bonusNumber2));
    }

    @DisplayName("보너스 번호가 1부터 45사이의 범위인지 테스트")
    @Test
    void 보너스_번호_범위_테스트() {
        List<Integer> number1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        String bonusNumber1 = "7";
        String bonusNumber2 = "50";

        assertDoesNotThrow(() -> Validator.validateBonusNumber(number1, bonusNumber1));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateBonusNumber(number1, bonusNumber2));
    }

}
