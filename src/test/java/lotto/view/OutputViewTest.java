package lotto.view;

import lotto.domain.Buyer;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    OutputView outputView = new OutputView();
    LottoService lottoService = new LottoService();

    @Test
    @DisplayName("구입 금액 입력 안내")
    void printInputPurchasePriceSentence() {
        outputView.printInputPurchasePriceSentence();
    }

    @Test
    @DisplayName("구입 금액 출력")
    void printPurchasePrice() {
        int purchasePrice = 14000;
        outputView.printPurchasePrice(purchasePrice);
    }

    @Test
    @DisplayName("구매 완료 및 발행 내역 안내")
    void printIssuingLotteryTicket() {
        int purchasePrice = 5000;
        Buyer buyer = lottoService.issueLotteryTicketAll(purchasePrice);
        outputView.printIssuingLotteryTicket(buyer.getLottos(), lottoService.getLotteryTicketCount(purchasePrice));
    }
}