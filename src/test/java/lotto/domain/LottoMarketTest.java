package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMarketTest {
    private final List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
    private final NumberGenerator generator = (minInclusive, maxInclusive, size) -> lottoNumbers;
    private final LottoFactory lottoFactory = new LottoFactory(generator);
    @Nested
    @DisplayName("buyLotto는")
    class BuyLotto {
        @DisplayName("로또 구입 금액을 받아서 LottoTicket을 반환한다")
        @Test
        void buyLotto() {
            // given
            int lottoPrice = 1000;
            LottoMarket lottoMarket = new LottoMarket(lottoPrice, lottoFactory);

            int lottoBoughtPrice = 10 * lottoPrice;

            // when
            LottoTicket lottoTicket = lottoMarket.buyLotto(lottoBoughtPrice);

            // then
            assertThat(lottoTicket).isNotNull();
        }

        @DisplayName("로또 구입 금액이 0보다 작을 시 예외를 던진다")
        @Test
        void buyLottoWithNegativePrice() {
            // given
            int lottoPrice = 1000;
            LottoMarket lottoMarket = new LottoMarket(lottoPrice, lottoFactory);

            int lottoBoughtPrice = -1;

            // when & then
            assertThatThrownBy(() -> lottoMarket.buyLotto(lottoBoughtPrice))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 구입 금액이 로또 하나 가격으로 나누어 떨어지지 않을 시 예외를 던진다")
        @Test
        void buyLottoWithNotDivisiblePrice() {
            // given
            int lottoPrice = 1000;
            LottoMarket lottoMarket = new LottoMarket(lottoPrice, lottoFactory);

            int lottoBoughtPrice = 1001;

            // when & then
            assertThatThrownBy(() -> lottoMarket.buyLotto(lottoBoughtPrice))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
