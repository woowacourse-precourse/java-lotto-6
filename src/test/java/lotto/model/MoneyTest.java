package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    @DisplayName("Money 객체가 재대로 생성 되는지 테스트")
    void createMoney() {
        String input = "3000";

        Money money = new Money(input);
        assertThat(money).isNotNull();
    }

    @Test
    @DisplayName("구입 금액이 숫자가 아니라면 예외 발생")
    void inputIsOnlyInteger() {
        String input = "hoyeon";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(input))
                .withMessage("[ERROR] 구입 금액은 숫자여야 합니다.");
    }

    @Test
    @DisplayName("구입 금액은 1000원 단위가 아니라면 예외 발생")
    void inputIsPaperMoney() {
        String money = "2500";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(money))
                .withMessage("[ERROR] 구입 금액은 1,000원 단위로 이루어져야 합니다.");
    }
}