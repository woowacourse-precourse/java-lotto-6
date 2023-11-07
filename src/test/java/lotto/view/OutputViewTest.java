package lotto.view;

import lotto.domain.Buyer;
import lotto.domain.Prize;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class OutputViewTest {

    OutputView outputView = new OutputView();
    LottoService lottoService = new LottoService();

    @Test
    @DisplayName("구입 금액 입력 안내")
    void printInputPurchasePriceSentence() {
        outputView.printInputPurchasePriceSentence();
    }

    @Test
    @DisplayName("구매 완료 및 발행 내역 안내")
    void printIssuingLotteryTicket() {
        int purchasePrice = 5000;
        Buyer buyer = lottoService.issueLotteryTicketAll(purchasePrice);
        outputView.printIssuingLotteryTicket(buyer.getLottos(), lottoService.getLotteryTicketCount(purchasePrice));
    }

    @Test
    @DisplayName("당첨 번호 입력 안내")
    void printInputWinningNumbersSentence() {
        outputView.printInputWinningNumbersSentence();
    }

    @Test
    @DisplayName("보너스 번호 입력 안내")
    void printBonusNumberSentence() {
        outputView.printBonusNumberSentence();
    }

    @Test
    @DisplayName("당첨 내역 안내")
    void printResult() {
        List<Prize> prizes = new ArrayList<>();
        prizes.add(Prize.FIFTH_PLACE);
        prizes.add(Prize.SECOND_PLACE);

        List<Integer> prizeCount = Arrays.asList(0, 0, 1, 0, 0, 1);

        outputView.printResult(prizes, prizeCount);
    }

    @Test
    @DisplayName("수익률 안내")
    void printRateOfReturn() {
        double value1 = 34.46757;
        double value2 = 200000.51;

        outputView.printRateOfReturn(value1);
        outputView.printRateOfReturn(value2);
    }
}