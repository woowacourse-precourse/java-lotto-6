package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.TestConstant;
import lotto.constant.Constants;
import lotto.domain.Rank;
import lotto.dto.LottoDto;
import lotto.dto.LottoReceiptDto;
import lotto.dto.LottoResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private final LottoService lottoService = TestConstant.TEST_LOTTO_CONFIG.lottoService();

    @DisplayName("구매 금액에 알맞은 로또 영수증을 반환한다.")
    @Test
    void getLottoReceipt() {
        int payment = Constants.LOTTO_PRICE;

        LottoReceiptDto lottoReceiptDto = lottoService.getLottoReceipt(payment);

        assertThat(lottoReceiptDto.purchaseCount()).isEqualTo(1);
        assertThat(lottoReceiptDto.lottos()).contains(new LottoDto(TestConstant.NORMAL_NUMBERS));
    }

    @DisplayName("로또 결과 통계를 반환한다.")
    @Test
    void getLottoResult() {
        givenPurchaseOneAndWinningFirstRank();

        LottoResultDto lottoResultDto = lottoService.getLottoResult();
        int firstRankCount = lottoResultDto.result().get(Rank.SIX_MATCH);
        int secondRankCount = lottoResultDto.result().get(Rank.FIVE_AND_BONUS_MATCH);
        double profitRate = lottoResultDto.profitRate();

        assertThat(firstRankCount).isEqualTo(1);
        assertThat(secondRankCount).isEqualTo(0);
        assertThat(profitRate).isEqualTo(200000000.0);
    }

    void givenPurchaseOneAndWinningFirstRank() {
        long payment = Constants.LOTTO_PRICE;
        lottoService.getLottoReceipt(payment);
        lottoService.drawLottoWithoutBonusNumber(TestConstant.NORMAL_NUMBERS);
        lottoService.drawBonusNumber(45);
    }
}