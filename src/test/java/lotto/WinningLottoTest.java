package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

  @DisplayName("당첨 번호에 보너스 번호와 같은 숫자가 있으면 예외가 발생한다.")
  @Test
  void createLottoByDuplicatedNumber() {
    int bonusNumber = 1;
    assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), bonusNumber))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
