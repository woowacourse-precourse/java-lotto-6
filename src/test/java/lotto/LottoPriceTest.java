package lotto;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Constants.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
class LottoPriceTest {
        @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
        @Test
        void createLottoPriceByNot1000() {
                assertThatThrownBy(() -> new LottoPrice(15500))
                        .isInstanceOf(IllegalArgumentException.class);
        }
        @DisplayName("구입 금액에 따른 lottoCount 계산")
        @Test
        void createLottoCountByPrice() {
                LottoPrice lottoPrice = new LottoPrice(10000);
                int result = lottoPrice.getLottoCount();
                assertThat(Integer.toString(result)).isEqualTo("10");
        }
}
