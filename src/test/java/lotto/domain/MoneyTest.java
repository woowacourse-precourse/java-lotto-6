package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    @DisplayName("금액이 숫자가 아니므로 예외가 발생한다.")
    void validateNumberFormat() throws Exception {
        //given
        String input = "1000j";
        //when
        //then
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 1000원 단위가 아니므로 예외가 발생한다.")
    void validateUnit() throws Exception {
        //given
        String input = "1100";
        //when
        //then
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 음수이므로 예외가 발생한다.")
    void validateNegativeNumber() throws Exception {
        //given
        String input = "-1000";
        //when
        //then
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("총 수익률을 계산하여 반환한다.")
    void calculateRevenue() throws Exception {
        //given
        String input1 = "8000";
        String input2 = "1000";
        double rewards1 = 5000;
        double rewards2 = 200000000;
        //when
        Money money1 = new Money(input1);
        Money money2 = new Money(input2);
        //then
        assertAll(
                () -> assertEquals(62.5, money1.calculateRevenue(rewards1)),
                () -> assertEquals(20000000.0, money2.calculateRevenue(rewards2))
        );
    }


}