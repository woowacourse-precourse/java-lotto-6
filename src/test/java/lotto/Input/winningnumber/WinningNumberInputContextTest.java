package lotto.Input.winningnumber;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.Either;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberInputContextTest {

  @DisplayName("당첨 번호가 정상적으로 입력되었을 때")
  @Test
  void validationWinningLotto() {
    // given
    String unValidatedNumbers = "1,2,3,4,5,6";

    // when
    Either<String, Lotto> either = WinningNumberInputContext.validatedWinningLotto(
        unValidatedNumbers);

    // then
    assertThat(either.isRight()).isTrue();
    assertThat(either.getRight().getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
  }

  @DisplayName("당첨 번호가 1~45 사이의 숫자가 아닐 때")
  @Test
  void if_winning_number_is_not_number() {
    // given
    String unValidatedNumbers = "1,2,3,4,5,46";

    // when
    Either<String, Lotto> either = WinningNumberInputContext.validatedWinningLotto(
        unValidatedNumbers);

    // then
    assertThat(either.isLeft()).isTrue();
    assertThat(either.getLeft()).isEqualTo("[ERROR]로또 번호는 6개의 숫자로 이루어져야 하며, 1~45 사이의 숫자만 가능합니다.");
  }

  @DisplayName("당첨 번호가 6개의 숫자가 아닐 때")
  @Test
  void if_winning_number_is_not_six() {
    // given
    String unValidatedNumbers = "1,2,3,4,5";

    // when
    Either<String, Lotto> either = WinningNumberInputContext.validatedWinningLotto(
        unValidatedNumbers);

    // then
    assertThat(either.isLeft()).isTrue();
    assertThat(either.getLeft()).isEqualTo("[ERROR]로또 번호는 6개의 숫자로 이루어져야 하며, 1~45 사이의 숫자만 가능합니다.");
  }

  @DisplayName("당첨 번호가 숫자와 쉼표가 아닌 다른 문자가 포함되어 있을 때")
  @Test
  void if_winning_number_is_not_number_and_comma() {
    // given
    String unValidatedNumbers = "1,2,3,4,5,a";

    // when
    Either<String, Lotto> either = WinningNumberInputContext.validatedWinningLotto(
        unValidatedNumbers);

    // then
    assertThat(either.isLeft()).isTrue();
    assertThat(either.getLeft()).isEqualTo("[ERROR]숫자와 쉼표만 입력 가능합니다.");
  }
}