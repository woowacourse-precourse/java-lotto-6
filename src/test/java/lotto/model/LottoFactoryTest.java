package lotto.model;

import static lotto.Constants.Constants.LOTTO_PRICE;
import static lotto.exception.LottoErrorCode.PURCHASE_AMOUNT_NOT_POSITIVE;
import static lotto.exception.LottoErrorCode.PURCHASE_AMOUNT_NOT_PRICE_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoFactoryTest {

    private final LottoFactory lottoTicketFactory = new LottoFactory();

    @Test
    void 구매_금액에_맞춰_티켓을_발행한다() {
        final int lottoCount = 3;
        final int purchaseAmount = LOTTO_PRICE * lottoCount;

        final List<Lotto> lottos = lottoTicketFactory.generateLottos(purchaseAmount);

        assertThat(lottos.size()).isEqualTo(lottoCount);
    }

    @Test
    void 티켓_가격_단위로_지불하지_않는다면_예외를_던진다() {
        final int purchaseAmount = LOTTO_PRICE + LOTTO_PRICE / 2;

        assertThatThrownBy(() -> lottoTicketFactory.generateLottos(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(PURCHASE_AMOUNT_NOT_PRICE_UNIT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1000})
    void 티켓_가격이_음수라면_예외를_던진다(final int purchaseAmount) {
        assertThatThrownBy(() -> lottoTicketFactory.generateLottos(purchaseAmount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(PURCHASE_AMOUNT_NOT_POSITIVE.getMessage());
    }

}