package lotto.utils;

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
    @DisplayName("배열의 갯수가 6개를 넘어가면 예외가 발생한다.")
    @Test
    void testLottoSize() {
        assertThatThrownBy(() -> validateLottoSize(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 범위인 1 ~ 45가 아니라면 예외가 발생한다.")
    @Test
    void testLottoRange() {
        assertThatThrownBy(() -> validateLottoRange(70))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("배열에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void testLottoDuplicates() {
        assertThatThrownBy(() -> validateLottoDuplicates(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최소 구입 금액보다 적은 금액을 입력 받아 예외 발생을 테스트한다.")
    @Test
    void testMinimumAmount() {
        assertThatThrownBy(() -> validateMinimumAmount(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원으로 나누어 떨어지지 않는 금액을 입력 받아 예외 발생을 테스트한다.")
    @Test
    void testDivisibleAmount() {
        assertThatThrownBy(() -> validateDivisibleAmount(1200))
                .isInstanceOf(IllegalArgumentException.class);
    }
}