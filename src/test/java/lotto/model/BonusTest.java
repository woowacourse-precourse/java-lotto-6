package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {

  private WinningLotto winningLotto;
  @BeforeEach
  void setup() {
    winningLotto = new WinningLotto(new Lotto(
        new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
  }

  @Test
  @DisplayName("보너스 숫자를 생성한다.")
  void testCreateBonus() {
    int bonusNumber = 22;
    Bonus bonus = new Bonus(new Number(bonusNumber), winningLotto);

    assertThat(bonus.getBonusNumber()).isEqualTo(bonusNumber);
  }

  @Test
  @DisplayName("로또에 있는 숫자와 중복되면 예외 발생시킨다.")
  void testDuplication() {
    int number = 1;
    Number duplicatedNumber = new Number(number);

    assertThatThrownBy(() -> new Bonus(duplicatedNumber, winningLotto))
        .isInstanceOf(IllegalArgumentException.class);
  }
}