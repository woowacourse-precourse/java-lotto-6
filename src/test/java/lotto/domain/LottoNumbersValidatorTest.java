package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersValidatorTest {
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다. 예외출력까지")
    @Test
    void createLottoByDuplicatedNumber2() {
        assertThatThrownBy(() -> LottoNumbersValidator.Validator(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    @DisplayName("로또 번호에 1보다 작은 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByNumberUnderOne() {
        assertThatThrownBy(() -> LottoNumbersValidator.Validator(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호에 45보다 큰 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByNumberOverfortyfive() {
        assertThatThrownBy(() -> LottoNumbersValidator.Validator(List.of(1, 2, 3, 4, 46, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
