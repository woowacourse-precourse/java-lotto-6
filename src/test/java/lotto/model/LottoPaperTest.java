package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPaperTest {

    @Test
    @DisplayName("금액에 맞추어 로또를 구매한다.")
    void totalPrice_buyLottoNumber() {
        String totalPrice = "8000";
        LottoPaper lottoPaper = new LottoPaper();

        int number = lottoPaper.buy(totalPrice);

        assertThat(number).isEqualTo(8);
    }


    @Test
    @DisplayName("로또 구매 금액이 천원 단위로 떨어지지 않으면 예외가 발생한다.")
    void buyPriceNotDivisibleByThousand() {
        String totalPrice = "8500";
        LottoPaper lottoPaper = new LottoPaper();

        assertThatThrownBy(() -> lottoPaper.buy(totalPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }
}