package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {


  @DisplayName("당첨 번호가 1보다 작은게 있으면 예외가 발생한다.")
  @Test
  void createWinningLottoUnderNumber() {
    assertThatThrownBy(() -> new WinningLotto(List.of(0, 2, 3, 4, 5, 6, 7), 8))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("당첨 번호가 45보다 큰게 있으면 예외가 발생한다.")
  @Test
  void createWinningLottoOverNumber() {
    assertThatThrownBy(() -> new WinningLotto(List.of(0, 2, 3, 4, 5, 6, 46), 8))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("당첨 번호의 개수가 6개가 초과면 예외가 발생한다.")
  @Test
  void createWinningLottoByOverSize() {
    assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6, 7), 8))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("당첨 번호의 개수가 6개가 미만이면 예외가 발생한다.")
  @Test
  void createWinningLottoByUnderSize() {
    assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5), 8))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("당첨 번호가 중복되면 예외가 발생한다.")
  @Test
  void validateWinningLottoNumberDuplicated() {
    assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 7, 7), 8))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
  @Test
  void validateWinningLottoNumberBonusNumberDuplicated() {
    assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("당첨 번호가 오름차순으로 정렬되는지 확인한다.")
  @Test
  void sortWinningLottoNumbers() {
    WinningLotto winningLotto = new WinningLotto(List.of(10, 5, 40, 31, 21, 9), 7);
    assertEquals(winningLotto.getNumbers(), List.of(5,9,10,21,31,40));
  }
}