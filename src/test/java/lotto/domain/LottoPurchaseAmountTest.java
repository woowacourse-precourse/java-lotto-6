package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseAmountTest {

    @Test
    @DisplayName("구입 금액이 1,000으로 나누어 떨어지지 않으면 예외 처리")
    void checkLottoPurchaseAmountDivideThousand() {
        // given
        String input = "2500";
        //then
        assertThatThrownBy(() -> new LottoPurchaseAmount(input)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력으로 숫자가 들어오지 않을 시 예외처리")
    void checkIsNumber() {
        //given
        String input = "abc";
        //then
        assertThatThrownBy(() -> new LottoPurchaseAmount(input)).isInstanceOf(
                IllegalArgumentException.class);

    }

    @Test
    @DisplayName("입력으로 빈칸이 들어올 시 예외처리")
    void checkIsBlack() {
        //given
        String input = " ";
        //then
        assertThatThrownBy(() -> new LottoPurchaseAmount(input)).isInstanceOf(
                IllegalArgumentException.class);

    }


}