package lotto.model.purchase;

import static lotto.fixture.LottoFixture.createLottoPurchaseAmount;
import static lotto.fixture.LottoFixture.createLottos;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.common.exception.ErrorMessage;
import lotto.model.lotto.Lotto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoPurchaseTest {
    @CsvSource({
            "1000, 1",
            "100000000, 100000"
    })
    @ParameterizedTest
    void 로또구입시_구입금액에_해당하는_개수만큼_로또를_반환한다(String amount, int lottoCount) {
        //given
        LottoPurchaseAmount lottoPurchaseAmount = createLottoPurchaseAmount(amount);
        List<Lotto> lottos = createLottos(lottoCount);
        //when
        LottoPurchase purchase = new LottoPurchase(lottoPurchaseAmount, lottos);
        //then
        assertThat(purchase.amount()).isEqualTo(lottoPurchaseAmount);
        assertThat(purchase.lottos()).hasSize(lottoCount);
    }

    @CsvSource({
            "1000, 2",
            "100000000, 99999"
    })
    @ParameterizedTest
    void 로또구입시_구입금액에_해당하지않는_개수만큼_로또를_반환하면_예외가_발생한다(String amount, int lottoCount) {
        //given
        LottoPurchaseAmount lottoPurchaseAmount = createLottoPurchaseAmount(amount);
        List<Lotto> lottos = createLottos(lottoCount);
        //when then
        assertThatThrownBy(() -> new LottoPurchase(lottoPurchaseAmount, lottos))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(ErrorMessage.INVALID_LOTTO_PURCHASE.getValue());
    }
}