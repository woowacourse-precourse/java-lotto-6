package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

  @Test
  @DisplayName("당첨 번호를 생성한다.")
  void testCreateWinningLotto() {
    List<Integer> inputNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    Lotto lotto = new Lotto(inputNumbers);
    WinningLotto winningLotto = new WinningLotto(lotto);

    assertThat(winningLotto.getWinningNumbers())
        .isSubsetOf(1, 2, 3, 4, 5, 6);
  }
}