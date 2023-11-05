package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyValidatorTest {

    @DisplayName("금액 입력 정상 테스트")
    @Test
    void userInputMoney() {
        assertThat(MoneyValidator.validate("1000")).isEqualTo(1000);
        assertThat(MoneyValidator.validate("1000000")).isEqualTo(1000000);

        assertThat(MoneyValidator.validate("8000")).isEqualTo(8000);
        assertThat(MoneyValidator.validate("58000")).isEqualTo(58000);
        assertThat(MoneyValidator.validate("358000")).isEqualTo(358000);
    }

    @DisplayName("금액 입력 숫자 예외 테스트")
    @Test
    void numberErrorMoney() {
        assertThatThrownBy(() -> MoneyValidator.validate("1000j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 숫자만 입력 가능합니다.");
    }

    @DisplayName("금액 입력 최소 금액 예외 테스트")
    @Test
    void minMoneyError() {
        assertThatThrownBy(() -> MoneyValidator.validate("100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소 금액은 1,000원 입니다.");

        assertThatThrownBy(() -> MoneyValidator.validate("10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소 금액은 1,000원 입니다.");
    }

    @DisplayName("금액 입력 최대 금액 예외 테스트")
    @Test
    void maxMoneyError() {
        assertThatThrownBy(() -> MoneyValidator.validate("100000000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최대 금액은 1,000,000원 입니다.");

        assertThatThrownBy(() -> MoneyValidator.validate("1358000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최대 금액은 1,000,000원 입니다.");
    }

    @DisplayName("금액 입력 1,000원 단위 예외 테스트")
    @Test
    void unitMoneyError() {
        assertThatThrownBy(() -> MoneyValidator.validate("10300"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 1,000원 단위로 입력 가능합니다.");

        assertThatThrownBy(() -> MoneyValidator.validate("10001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 1,000원 단위로 입력 가능합니다.");

        assertThatThrownBy(() -> MoneyValidator.validate("10020"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 1,000원 단위로 입력 가능합니다.");

    }
}
