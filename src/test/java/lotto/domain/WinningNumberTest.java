package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {

    @DisplayName("[EXCEPTION]당첨 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void createWinningNumberByWrongSize() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 1부터 45사이의 중복되지 않는 6개의 숫자여야 합니다.");
    }

    @DisplayName("[EXCEPTION]당첨 번호의 범위가 잘못된 경우 예외가 발생한다.")
    @Test
    void createWinningNumberByWrongRange() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 1부터 45사이의 중복되지 않는 6개의 숫자여야 합니다.");
    }


    @DisplayName("[EXCEPTION]당첨 번호에 중복이 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplication() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 1부터 45사이의 중복되지 않는 6개의 숫자여야 합니다.");
    }

    @DisplayName("[SUCCESS]당첨 번호에 특정한 번호가 포함된 경우 true를 반환한다.")
    @Test
    void checkWinningNumberContainSpecificNumber() {
        // given
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));

        // when, then
        assertThat(winningNumber.isContainNumber(6))
                .isEqualTo(true);
    }

    @DisplayName("[SUCCESS]당첨 번호에 특정한 번호가 포함되지 않은 경우 false를 반환한다.")
    @Test
    void checkWinningNumberNotContainSpecificNumber() {
        // given
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));

        // when, then
        assertThat(winningNumber.isContainNumber(7))
                .isEqualTo(false);
    }

    @DisplayName("[SUCCESS]하나의 로또에 대해 맞춘 번호 개수를 반환한다.")
    @Test
    void calculateHitNumberByOneLotto() {
        // given
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 8, 9, 10, 11));

        // when, then
        assertThat(winningNumber.hitCount(lotto))
                .isEqualTo(2);
    }

}