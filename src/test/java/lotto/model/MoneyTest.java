package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("금액_테스트")
class MoneyTest {

    @Test
    @DisplayName("빈_값_입력_예외")
    void createMoneyEx1() {
        String inputNon = "";
        String inputSpace = " ";

        Assertions.assertThatThrownBy(() -> new Money(inputNon))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Money.INPUT_POSITIVE_ERROR);

        Assertions.assertThatThrownBy(() -> new Money(inputSpace))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Money.INPUT_POSITIVE_ERROR);
    }

    @Test
    @DisplayName("문자_입력_예외")
    void createMoneyEx2() {
        String inputString = "10만원";

        Assertions.assertThatThrownBy(() -> new Money(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Money.INPUT_POSITIVE_ERROR);
    }

    @Test
    @DisplayName("소수점_입력_예외")
    void createMoneyEx3() {
        String inputDouble = "3000.3";

        Assertions.assertThatThrownBy(() -> new Money(inputDouble))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Money.INPUT_POSITIVE_ERROR);
    }

    @Test
    @DisplayName("단위_예외")
    void createMoneyEx4() {
        String correctInput = "8000";
        String wrongInput = "8120";
        int resultMoney = 8000;
        Money expectMoney = new Money(correctInput);

        Assertions.assertThat(expectMoney.getMoney()).isEqualTo(resultMoney);

        Assertions.assertThatThrownBy(() -> new Money(wrongInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Money.MONEY_UNIT_ERROR);
    }

}