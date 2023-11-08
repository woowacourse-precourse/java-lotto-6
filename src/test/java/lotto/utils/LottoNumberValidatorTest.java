package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberValidatorTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> LottoNumberValidator.validateNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호의 갯수 6개를 만족해야합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 3, 6);
        assertThatThrownBy(() -> LottoNumberValidator.validateNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 중복될 수 없습니다.");
    }

    @DisplayName("로또 번호의 숫자가 1~45의 범위를 만족하지 않을시 예외가 발생한다.")
    @Test
    void createLottoByImproperNumber() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 47);
        assertThatThrownBy(() -> LottoNumberValidator.validateNumbers(numbers))
                .hasMessage("로또 숫자는 1~45의 범위를 만족해야합니다.");
    }
}
