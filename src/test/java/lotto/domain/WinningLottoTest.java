package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
  @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
  @Test
  void createWinningLottoByDuplicatedBonusNumber() {
    assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6, 7), 6))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("당첨 번호에 0이 있으면 예외가 발생한다.")
  @Test
  void createWinningLottoByZero() {
    assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 0), 6))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("당첨 번호가 1~45가 아니면 예외가 발생한다.")
  @Test
  void createWinningLottoByOverMaxNumber() {
    assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 46), 6))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("보너스 번호에 0이 있으면 예외가 발생한다.")
  @Test
  void createWinningLottoByZeroBonusNumber() {
    assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 0))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("보너스 번호가 1~45가 아니면 예외가 발생한다.")
  @Test
  void createWinningLottoByOverMaxBonusNumber() {
    assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 46))
            .isInstanceOf(IllegalArgumentException.class);
  }
}