package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInputNumbersTest {

  @DisplayName("당첨 번호의 개수가 6개를 넘어가는 경우 예외가 발생한다.")
  @Test
  void createNumberByOverSize() {
    assertThatThrownBy(() -> new UserInputNumbers(List.of(1, 2, 3, 4, 5, 6, 7), 8))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("당첨 번호의 범위가 1~45가 아닌 경우 예외가 발생한다.")
  @Test
  void createNumberByInvalidNumber() {
    assertThatThrownBy(() -> new UserInputNumbers(List.of(0, 2, 3, 4, 5, 6), 7))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> new UserInputNumbers(List.of(1, 2, 3, 4, 5, 46), 7))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("당첨 번호에 중복된 숫자가 있는 경우 예외가 발생한다.")
  @Test
  void createNumberByDuplicatedNumber() {
    assertThatThrownBy(() -> new UserInputNumbers(List.of(1, 2, 3, 4, 5, 5), 7))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
