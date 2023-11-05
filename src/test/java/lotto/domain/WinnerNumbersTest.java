package lotto.domain;

import static lotto.error.ExceptionCode.DUPLICATED_LOTTO_NUMBER;
import static lotto.error.ExceptionCode.INVALID_LOTTO_NUMBER;
import static lotto.error.ExceptionCode.INVALID_LOTTO_NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.error.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinnerNumbersTest {

    @DisplayName("번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinnerNumbersByOverSize() {
        // given & when & then
        assertThatThrownBy(() -> new WinnerNumbers(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }

    @DisplayName("번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinnerNumbersByDuplicatedNumber() {
        // given & when & then
        assertThatThrownBy(() -> new WinnerNumbers(List.of(1, 2, 3, 4, 5, 5), 7))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(DUPLICATED_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호와의 중복도 예외가 발생한다.")
    @Test
    void createWinnerNumbersByDuplicatedBonusNumber() {
        // given & when & then
        assertThatThrownBy(() -> new WinnerNumbers(List.of(1, 2, 3, 4, 5, 6), 5))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(DUPLICATED_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("번호가 1~45가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void createWinnerNumbersByUnderOrOverNumber(final Integer number) {
        // given & when & then
        assertThatThrownBy(() -> new WinnerNumbers(List.of(number, 2, 3, 4, 5, 6), 7))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("번호를 포함하고 있는지 확인한다,")
    @Test
    void containNumber() {
        // given
        final WinnerNumbers winnerNumbers = new WinnerNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        final boolean actual = winnerNumbers.containNumber(1);

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("번호를 포함하고 있지 않다면 false를 반환한다.")
    @Test
    void notContainNumber() {
        // given
        final WinnerNumbers winnerNumbers = new WinnerNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        final boolean actual = winnerNumbers.containNumber(8);

        // then
        assertThat(actual).isFalse();
    }

    @DisplayName("보너스 번호를 포함하고 있는지 확인한다,")
    @Test
    void containBonusNumber() {
        // given
        final WinnerNumbers winnerNumbers = new WinnerNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        final boolean actual = winnerNumbers.containBonusNumber(7);

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("보너스 번호를 포함하고 있지 않다면 false를 반환한다.")
    @Test
    void notContainBonusNumber() {
        // given
        final WinnerNumbers winnerNumbers = new WinnerNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        final boolean actual = winnerNumbers.containBonusNumber(8);

        // then
        assertThat(actual).isFalse();
    }
}
