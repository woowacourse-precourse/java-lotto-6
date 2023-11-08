package lotto.domain;

import static lotto.common.ErrorMessages.NEGATIVE_VALUE_MESSAGE;
import static lotto.common.ErrorMessages.NOT_IN_1000_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.InputValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPurchaseCostTest {

    @DisplayName("돈을 생성하면 돈이 생성된다.")
    @Test
    void createMoney() {
        LottoPurchaseCost lottoPurchaseCost = new LottoPurchaseCost(1000);

        assertThat(lottoPurchaseCost.getLottoPurchaseCost()).isEqualTo(1000);
    }

    @DisplayName("올바르지 않은 금액을 입력하면 에러가 발생한다")
    @Test
    void invalidInputMoney() {
        assertThatThrownBy(() -> new LottoPurchaseCost(-1))
                .isInstanceOf(InputValidationException.class)
                .hasMessageContaining(NEGATIVE_VALUE_MESSAGE.getMessage());
    }

    @DisplayName("1000으로 나누어지지 않는 숫자를 넘기면 에러가 발생한다.")
    @Test
    void exceptionDivideBy1000Money() {
        assertThatThrownBy(() -> new LottoPurchaseCost(1234))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_IN_1000_UNIT.getMessage());
    }

    @DisplayName("1000으로 나눈 값이 반환된다.")
    @Test
    void getDividedThousandWonCount() {
        LottoPurchaseCost lottoPurchaseCost = new LottoPurchaseCost(8000);

        assertThat(lottoPurchaseCost.getDividedThousandWonCount()).isEqualTo(8);
    }
}
