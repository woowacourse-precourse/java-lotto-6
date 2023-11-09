package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PurchaseAmount의")
class PurchaseAmountTest {

    @Test
    @DisplayName("1000으로 나눈 반환 값을 반환하는가")
    void return_divide_by_thousand() {
        //given
        final Integer input = 10000;
        final Integer expected = 10;
        final PurchaseAmount purchaseAmount = new PurchaseAmount(input);

        //when
        final Integer actualInput = purchaseAmount.getDivideByThousand();

        //then
        assertThat(actualInput).isEqualTo(expected);
    }

    @Test
    @DisplayName("amount가 1000으로 안나눠지면 에외를 던지는가")
    void is_not_divided_by_one_thousand() {
        //given
        final Integer input = 1001;

        //when & then
        assertThatThrownBy(() -> new PurchaseAmount(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("amount가 100,000이 넘어가면 에외를 던지는가")
    void is_over_ten_thousand() {
        //given
        final Integer input = 101000;

        //when & then
        assertThatThrownBy(() -> new PurchaseAmount(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("amount가 정상이면 예외를 안던지는가")
    void is_divided_by_one_thousand() {
        //given
        final Integer input = 1000;

        //when & then
        assertThatNoException().isThrownBy(() -> new PurchaseAmount(input));
    }
}
