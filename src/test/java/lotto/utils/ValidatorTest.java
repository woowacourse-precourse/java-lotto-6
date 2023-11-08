package lotto.utils;

import static lotto.utils.Validator.validateBonusDuplicates;
import static lotto.utils.Validator.validateDivisibleAmount;
import static lotto.utils.Validator.validateLottoDuplicates;
import static lotto.utils.Validator.validateLottoRange;
import static lotto.utils.Validator.validateLottoSize;
import static lotto.utils.Validator.validateMinimumAmount;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    @DisplayName("로또의 갯수가 6개를 넘어가면 예외가 발생한다.")
    @Test
    void 로또_갯수_테스트() {
        assertThatThrownBy(() -> validateLottoSize(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 숫자가 범위인 1 ~ 45가 아니라면 예외가 발생한다.")
    @Test
    void 로또_숫자_범위_테스트() {
        assertThatThrownBy(() -> validateLottoRange(70))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_중복_테스트() {
        assertThatThrownBy(() -> validateLottoDuplicates(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또와 보너스 번호가 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_보너스_중복_테스트() {
        assertThatThrownBy(() -> validateBonusDuplicates(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최소 구입 금액보다 적은 금액을 입력 받아 예외 발생을 테스트한다.")
    @Test
    void 로또_최소_구입_금액_테스트() {
        assertThatThrownBy(() -> validateMinimumAmount(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원으로 나누어 떨어지지 않는 금액을 입력 받아 예외 발생을 테스트한다.")
    @Test
    void 로또_나누기_구입_금액_테스트() {
        assertThatThrownBy(() -> validateDivisibleAmount(1200))
                .isInstanceOf(IllegalArgumentException.class);
    }
}