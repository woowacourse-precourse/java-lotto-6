package lotto.view;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

class OutputViewTest {

    OutputView outputView = new OutputView();
    LottoService lottoService = new LottoService();

    @Test
    @DisplayName("구입 금액 입력 안내")
    void outputPurchasePrice() {
        System.setIn(new ByteArrayInputStream("14000".getBytes()));
        outputView.outputPurchasePrice();
    }

    @Test
    @DisplayName("구매 완료 및 발행 내역 안내")
    void outputIssuingLotteryTicket() {
        System.setIn(new ByteArrayInputStream("5000".getBytes()));
        Buyer buyer = lottoService.issueLotteryTicketAll();
        outputView.outputIssuingLotteryTicket(buyer.getLottos(), lottoService.getTicketCount());
    }
}