package lotto.service;

import static lotto.fixture.LottoFixture.createLottoPurchaseAmount;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.controller.dto.input.LottoPurchaseAmountDto;
import lotto.mock.MockLottoNumberGenerator;
import lotto.model.purchase.LottoPurchase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoPurchaseServiceTest {
    private final MockLottoNumberGenerator mockLottoNumberGenerator = new MockLottoNumberGenerator();
    private final LottoPurchaseService lottoPurchaseService = new LottoPurchaseService(mockLottoNumberGenerator);

    @CsvSource({
            "1000, 1",
            "100000000, 100000"
    })
    @ParameterizedTest
    void 로또구입시_구입금액에_해당하는_개수만큼_로또를_반환한다(String amount, int lottoCount) {
        //given
        LottoPurchaseAmountDto lottoPurchaseAmountDto = new LottoPurchaseAmountDto(amount);
        //when
        LottoPurchase purchase = lottoPurchaseService.purchase(lottoPurchaseAmountDto);
        //then
        assertThat(purchase.amount()).isEqualTo(createLottoPurchaseAmount(amount));
        assertThat(purchase.lottos()).hasSize(lottoCount);
    }
}