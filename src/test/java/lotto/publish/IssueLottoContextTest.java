package lotto.publish;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IssueLottoContextTest {

  @DisplayName("로또 발행 테스트")
  @Test
  void issue() {
    // given
    IssuedNumber issuedNumber = IssuedNumber.of(3).getRight();

    // when
    IssuedLottoEvent issuedLottoEvent = IssueLottoContext.issue(
        IssueLottoCommand.of(issuedNumber));

    // then
    assertThat(issuedLottoEvent.getIssuedNumber().getValue()).isEqualTo(3);
    assertThat(issuedLottoEvent.getLottos().get(0).getNumbers()).isSorted();
    assertThat(issuedLottoEvent.getLottos().stream().map(Lotto::size)
        .allMatch(size -> size == 6)).isTrue();
    assertThat(issuedLottoEvent.getLottos().stream().map(Lotto::getNumbers).allMatch(
        numbers -> numbers.stream().allMatch(number -> number >= 1 && number <= 45))).isTrue();
  }
}