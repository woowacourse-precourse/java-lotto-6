package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.util.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @DisplayName("구입금액이 공백이라면 예외가 발생하고 false를 반환한다.")
    @Test
    void verifyPurchaseAmountByEmptyOrBlank() {
        assertThat(Validator.verifyPurchaseAmount("")).isFalse();
    }

    @DisplayName("구입금액에 문자가 포함되어있다면 예외가 발생하고 false를 반환한다.")
    @Test
    void verifyPurchaseAmountByIncludeCharacter() {
        assertThat(Validator.verifyPurchaseAmount("a")).isFalse();
    }

    @DisplayName("구입금액이 1000원 미만이라면 예외가 발생하고 false를 반환한다.")
    @Test
    void verifyPurchaseAmountByUnderThousand() {
        assertThat(Validator.verifyPurchaseAmount("999")).isFalse();
    }

    @DisplayName("구입금액이 1000으로 나누어 떨어지지 않으면 예외가 발생하고 false를 반환한다.")
    @Test
    void verifyPurchaseAmountByIndivisibleToThousand() {
        assertThat(Validator.verifyPurchaseAmount("1234")).isFalse();
    }

    @DisplayName("당첨 번호가 공백이라면 예외가 발생하고 false를 반환한다.")
    @Test
    void verifyWinNumberByEmptyOrBlank() {
        assertThat(Validator.verifyWinNumber("")).isFalse();
    }

    @DisplayName("당첨 번호에 문자가 포함되어 있다면 예외가 발생하고 false를 반환한다.")
    @Test
    void verifyWinNumberByIncludeCharacter() {
        assertThat(Validator.verifyWinNumber("a,1,2,3,4,5")).isFalse();
    }

    @DisplayName("보너스 번호가 공백이라면 예외가 발생하고 false를 반환한다.")
    @Test
    void verifyBonusNumberByEmptyOrBlank() {
        Lotto wiNumber = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(Validator.verifyBonusNumber(wiNumber, "")).isFalse();
    }

    @DisplayName("보너스 번호에 문자가 포함되어 있다면 예외가 발생하고 false를 반환한다.")
    @Test
    void verifyBonusNumberByIncludeCharacter() {
        Lotto wiNumber = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(Validator.verifyBonusNumber(wiNumber, "a")).isFalse();
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복된다면 예외가 발생하고 false를 반환한다.")
    @Test
    void verifyBonusNumberByDuplicateInWinNumber() {
        Lotto wiNumber = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(Validator.verifyBonusNumber(wiNumber, "3")).isFalse();
    }

    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생하고 false를 반환한다.")
    @Test
    void verifyBonusNumberByOutOfRange() {
        Lotto wiNumber = new Lotto(List.of(1,2,3,4,5,6));
        assertThat(Validator.verifyBonusNumber(wiNumber, "46")).isFalse();
    }
}
