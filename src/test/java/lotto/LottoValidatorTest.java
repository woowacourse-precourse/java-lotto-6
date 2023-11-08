package lotto;

import lotto.validate.LottoValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoValidatorTest {

    @DisplayName("입력 금액이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenPurchaseAmountIsNotNumber() {
        String input = "abc134";

        assertThatThrownBy(() -> LottoValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 숫자여야 합니다.");
    }

    @DisplayName("입력 금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenPurchaseAmountIsNotMultipleOfThousand() {
        String input = "1500";

        assertThatThrownBy(() -> LottoValidator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
    }

    @DisplayName("입력된 로또 번호가 유효한 1~45 범위 바깥일 경우 예외가 발생한다.")
    @Test
    void throwExceptionWhenLottoNumberNotInRange() {
        assertThatThrownBy(() -> LottoValidator.validateLottoNumber(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        Assertions.assertThatThrownBy(() -> LottoValidator.validateLottoNumber(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개만 받습니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        Assertions.assertThatThrownBy(() -> LottoValidator.validateLottoNumber(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복을 허용하지 않습니다.");
    }

    @DisplayName("입력된 보너스 번호가 유효한 범위 바깥일 경우 예외가 발생한다.")
    @Test
    public void throwExceptionForInvalidBonusNumber() {
        int bonusNumber = 46;
        assertThatThrownBy(() -> LottoValidator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("입력된 보너스 번호가 로또 번호와 중복될 경우 예외가 발생한다.")
    @Test
    public void throwExceptionForDuplicateBonusNumber() {
        int bonusNumber = 6;
        assertThatThrownBy(() -> LottoValidator.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 로또 번호와의 중복이 허용되지 않습니다.");
    }
}