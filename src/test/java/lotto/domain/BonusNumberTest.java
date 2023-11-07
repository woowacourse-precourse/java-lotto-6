package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

  @DisplayName("보너스 번호 구간 확인")
  @Test
  void isEmpty() {
    String input = "46";

    assertThatThrownBy(() -> BonusNumberValidator.isValueInRange(input))
        .isInstanceOf(IllegalArgumentException.class);
  }


}
