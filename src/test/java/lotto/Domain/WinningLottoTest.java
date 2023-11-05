package lotto.Domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("당첨번호가 6개의 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createWinningLottoByFiveNumber() {
        Assertions.assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5), 45))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 중복된 숫자가 있다면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicateNumber() {
        Assertions.assertThatThrownBy(() -> new WinningLotto(List.of(1, 1, 2, 3, 4, 5), 45))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 1부터 45까지의 번호가 아닌 숫자가 있다면 예외가 발생한다.")
    @Test
    void createWinningLottoByOutOfBoundNumber() {
        Assertions.assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 46), 45)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1부터 45까지의 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createWinningLottoByOutOfBoundBonusNumber() {
        Assertions.assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 46)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있는 숫자라면 예외가 발생한다.")
    @Test
    void createWinningLottoByWinningNumbersIncludeBonusNumber() {
        Assertions.assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6)).isInstanceOf(
                IllegalArgumentException.class);
    }
}