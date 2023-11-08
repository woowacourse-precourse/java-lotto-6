package lotto.Input.winningnumber;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.Either;
import lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberInputContextTest {

  @DisplayName("정상적으로 입력되었을 때")
  @Test
  void input_number() {
    // given
    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    String number = "7";

    // when
    Either<String, ValidatedBonusNumber> bonusNumberEither = BonusNumberInputContext.validatedBonusNumber(
        lotto, number);

    // then
    assertThat(bonusNumberEither.isRight()).isTrue();
    assertThat(bonusNumberEither.getRight().getBonusNumber()).isEqualTo(7);
    assertThat(bonusNumberEither.getRight().getBonusNumber()).isNotIn(lotto.getNumbers());
  }

  @DisplayName("보너스 번호가 당첨 번호와 중복될 때")
  @Test
  void if_bonus_number_is_already_exist() {
    // given
    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    String number = "6";

    // when
    Either<String, ValidatedBonusNumber> bonusNumberEither = BonusNumberInputContext.validatedBonusNumber(
        lotto, number);

    // then
    assertThat(bonusNumberEither.isLeft()).isTrue();
    assertThat(bonusNumberEither.getLeft()).isEqualTo("[ERROR]보너스 번호는 당첨 번호와 중복될 수 없습니다.");
  }

  @DisplayName("보너스 번호가 1~45 사이의 숫자가 아닐 때")
  @ParameterizedTest()
  @ValueSource(strings = {"0", "46", "a", "1.1", "1,1", "1 1"})
  void if_bonus_number_is_not_number(String number) {
    // given
    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    // when
    Either<String, ValidatedBonusNumber> bonusNumberEither = BonusNumberInputContext.validatedBonusNumber(
        lotto, number);

    // then
    assertThat(bonusNumberEither.isLeft()).isTrue();
    assertThat(bonusNumberEither.getLeft()).isEqualTo("[ERROR]보너스 번호는 1~45 사이의 숫자만 가능합니다.");
  }
}