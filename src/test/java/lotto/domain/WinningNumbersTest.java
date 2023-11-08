package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    @DisplayName("WinningNumbers 생성 테스트")
    void createWinningNumbers() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningNumbers.getGeneralNumbers())
                .containsAll(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(winningNumbers.getBonusNumber(), 7);
    }

    @Test
    @DisplayName("당첨 번호가 6개 미만일 경우 예외처리")
    void validateWinningNumbersUnderSize() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 6개 초과일 경우 예외처리")
    void validateWinningNumbersOverSize() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("일반 당첨 번호가 중복되었을 경우 예외처리")
    void validateDuplicateGeneralNumbers() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("일반 당첨 번호와 보너스 번호가 중복되었을 경우 예외처리")
    void validateDuplicateBonusNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("번호가 1 미만일 경우 예외처리")
    void validateUnderRangeWinningNumbers() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(0, 2, 3, 4, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("번호가 45 초과일 경우 예외처리")
    void validateOverRangeWinningNumbers() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(46, 2, 3, 4, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또와 맞는 당첨 번호 세기 테스트")
    void countMatchedNumberWithLotto() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        Lotto lotto = new Lotto(List.of(7, 8, 35, 42, 43, 44));
        int matchedNumber = winningNumbers.countMatchedNumber(lotto);
        assertThat(matchedNumber).isEqualTo(0);

        lotto = new Lotto(List.of(1, 6, 35, 42, 43, 44));
        matchedNumber = winningNumbers.countMatchedNumber(lotto);
        assertThat(matchedNumber).isEqualTo(2);

        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        matchedNumber = winningNumbers.countMatchedNumber(lotto);
        assertThat(matchedNumber).isEqualTo(6);
    }
    @Test
    @DisplayName("로또와 맞는 보너스 번호 세기 테스트")
    void hasBonusNumberWithLotto() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        Lotto lotto = new Lotto(List.of(1, 6, 35, 42, 43, 44));
        boolean hasBonusNumber = winningNumbers.hasBonusNumber(lotto);
        assertThat(hasBonusNumber).isEqualTo(false);

        lotto = new Lotto(List.of(1, 6, 7, 42, 43, 44));
        hasBonusNumber = winningNumbers.hasBonusNumber(lotto);
        assertThat(hasBonusNumber).isEqualTo(true);
    }
}