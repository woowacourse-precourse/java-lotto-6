package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

  @Test
  @DisplayName("똑같은 Number 객체인지 확인한다.")
  void testSameObject() {
    Number number1 = new Number(1);
    Number number2 = new Number(1);

    assertThat(number1).isEqualTo(number2);
  }
  @ParameterizedTest
  @ValueSource(ints = {0, 46})
  @DisplayName("1~45 범위의 수를 제외하면 예외를 발생시킨다.")
  void testNumberInRange(int exceptionNumber) {
    assertThatThrownBy(() -> new Number(exceptionNumber))
        .isInstanceOf(IllegalArgumentException.class);
  }

}