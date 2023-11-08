package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoWinningNumberTest {

    @DisplayName("당첨 번호를 생성한다.")
    @Test
    void createLottoWinningNumber() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when, then
        Assertions.assertThatCode(() -> new LottoWinningNumber(numbers, bonusNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("당첨 번호가 중복이면 예외가 발생한다.")
    @Test
    void validateDuplicationNumberSize() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 3, 5, 6);
        int bonusNumber = 7;

        // when, then
        Assertions.assertThatThrownBy(() -> new LottoWinningNumber(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있으면 예외가 발생한다.")
    @Test
    void validateDuplicationBonusNumber() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 1;

        // when, then
        Assertions.assertThatThrownBy(() -> new LottoWinningNumber(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}