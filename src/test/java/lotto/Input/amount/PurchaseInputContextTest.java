package lotto.Input.amount;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.Either;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseInputContextTest {

  @DisplayName("정상적으로 입력되었을 때")
  @Test
  void inputPurchase() {
    // given

    // when
    Either<String, IssuedNumber> stringIssuedNumberEither = PurchaseInputConext.inputPurchaseAmount("9000",
        1000);

    // then
    assertThat(stringIssuedNumberEither.isRight()).isTrue();
    assertThat(stringIssuedNumberEither.getRight().getValue()).isEqualTo(9);
  }

  @DisplayName("숫자가 아닌 값이 입력되었을 때")
  @Test
  void if_input_not_number() {
    // given

    // when
    Either<String, IssuedNumber> stringIssuedNumberEither = PurchaseInputConext.inputPurchaseAmount("90-0",
        1000);

    // then
    assertThat(stringIssuedNumberEither.isLeft()).isTrue();
    assertThat(stringIssuedNumberEither.getLeft()).isEqualTo("[ERROR]: 숫자만 입력 가능합니다.");
  }

  @DisplayName("구입 금액이 1000원 미만이거나 1000원 단위로 나누어 떨어지지 않았을 때")
  @Test
  void if_if_not_divided() {
    // given

    // when
    Either<String, IssuedNumber> stringIssuedNumberEither = PurchaseInputConext.inputPurchaseAmount("9100",
        1000);

    // then
    assertThat(stringIssuedNumberEither.isLeft()).isTrue();
    assertThat(stringIssuedNumberEither.getLeft()).isEqualTo("[ERROR]: 구입 금액은 1000원 이상이며 1000원 단위로만 가능합니다.");
  }
}