package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import lotto.util.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @DisplayName("당첨 번호가 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicateNumber() {
        assertThatThrownBy(() -> new Validator().validateDuplication(new ArrayList<>(Arrays
                .asList("1", "2", "3", "4", "4", "5"))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨번호에 이미 존재하는 값이면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicateWinningNumber() {
        assertThatThrownBy(() -> new Validator().validateBonusNumber("1", new ArrayList<>(Arrays
                .asList(1, 2, 3, 4, 5))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액이 1000으로 나누어 떨어지지 않는다면 예외가 발생한다.")
    @Test
    void createBudgetByNotDivideOneK() {
        assertThatThrownBy(() -> new Validator().validateBudget("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값에 쉼표가 포함되지 않으면 예외가 발생한다.")
    @Test
    void creatInputByNonComma() {
        assertThatThrownBy(() -> new Validator().isContainComma("1 2 3 4 5 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
