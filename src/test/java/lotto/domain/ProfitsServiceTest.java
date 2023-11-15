package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.service.LottoService;
import lotto.service.ProfitsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitsServiceTest {

    Buyer buyer;
    ProfitsService profitsService;
    LottoNumber lottoNumber = new LottoNumber();
    LottoService lottoService = new LottoService();

    @DisplayName("구매자의 당첨 결과 통계를 기준으로 총 당첨금을 계산한다.")
    @Test
    void calculateBuyerProfitsByWiningResult() {
        List<Lotto> buyerLottoTickets = new ArrayList<>();
        buyerLottoTickets.add(createFirstTestTicket());
        buyerLottoTickets.add(createSecondTestTicket());
        buyerLottoTickets.add(createThirdTestTicket());

        buyer = new Buyer(3000, 3, buyerLottoTickets); // 구매자 로또 번호 배정
        lottoNumber.drawWiningNumbers("1,2,3,10,11,12"); // 당첨 번호
        lottoNumber.drawBonusNumber("7"); // 보너스 번호

        profitsService = new ProfitsService(buyer);
        lottoService.compareLottoNumber(buyer, lottoNumber);
        profitsService.calculateRateOfReturn(lottoService);

        assertThat(profitsService.getBuyerProfits()).isEqualTo(5000); // 5,000원 당첨
    }

    @DisplayName("구매자의 구입 금액 대비 당첨금에 대한 수익률을 계산한다.")
    @Test
    void calculateRateOfReturnByBuyerPurchaseAmount() {
        List<Lotto> buyerLottoTickets = new ArrayList<>();
        buyerLottoTickets.add(createFirstTestTicket());
        buyerLottoTickets.add(createSecondTestTicket());
        buyerLottoTickets.add(createThirdTestTicket());

        buyer = new Buyer(3000, 3, buyerLottoTickets);  // 로또 구매 금액 3,000원
        lottoNumber.drawWiningNumbers("1,2,3,10,11,12"); // 당첨 번호
        lottoNumber.drawBonusNumber("7"); // 보너스 번호

        profitsService = new ProfitsService(buyer);
        lottoService.compareLottoNumber(buyer, lottoNumber);
        profitsService.calculateRateOfReturn(lottoService);

        assertThat(String.format("%.1f", profitsService.getRateOfReturn())).isEqualTo("166.7");
        // 3,000원 구매 대비 5,000원 수익 (수익률 166.7%)
    }

    private Lotto createFirstTestTicket() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        return lotto;
    }

    private Lotto createSecondTestTicket() {
        Lotto lotto = new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7));
        return lotto;
    }

    private Lotto createThirdTestTicket() {
        Lotto lotto = new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8));
        return lotto;
    }
}