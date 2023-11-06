package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.TestConstant;
import lotto.constant.LottoConstraint;
import lotto.constant.LottoRank;
import lotto.dto.LottoDto;
import lotto.dto.LottoReceiptDto;
import lotto.dto.LottoResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private static final LottoDto lottoDto = new LottoDto(TestConstant.normalNumbers);

    private final LottoService lottoService = TestConstant.testLottoConfig.lottoService();

    @DisplayName("구매 금액에 알맞은 로또 영수증을 반환한다.")
    @Test
    void getLottoReceipt() {
        int payment = LottoConstraint.PRICE_PER_LOTTO.getValue();

        LottoReceiptDto lottoReceiptDto = lottoService.getLottoReceipt(payment);

        assertThat(lottoReceiptDto.purchaseCount()).isEqualTo(1);
        assertThat(lottoReceiptDto.lottos()).contains(lottoDto);
    }

    @DisplayName("로또 결과 통계를 반환한다.")
    @Test
    void getLottoResult() {
        int payment = TestConstant.minPaymentAmount;
        lottoService.getLottoReceipt(payment);
        lottoService.drawLottoWithoutBonusNumber(TestConstant.normalNumbers);
        lottoService.generateWinningLotto(45);

        LottoResultDto lottoResultDto = lottoService.getLottoResult();

        //TODO : 변수 위치 이동
        double sixMatchedProfitRate
                = (double) LottoRank.SIX_MATCH.getPrizeMoney() / LottoConstraint.PRICE_PER_LOTTO.getValue();
        assertThat(lottoResultDto.profitRate()).isEqualTo(sixMatchedProfitRate);
        assertThat(lottoResultDto.result().get(LottoRank.SIX_MATCH))
                .isEqualTo(LottoConstraint.MIN_PURCHASE_QUANTITY.getValue());
    }
}
