package lotto.view;

import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class OutputViewTest {

    OutputView outputView = new OutputView();

    @Test
    @DisplayName("구입 금액 입력 안내")
    void outputPurchasePrice() {
        System.setIn(new ByteArrayInputStream("14000".getBytes()));
        outputView.outputPurchasePrice();
    }

    @Test
    @DisplayName("구매 완료 및 발행 내역 안내")
    void outputIssuingLotteryTicket() {
        System.setIn(new ByteArrayInputStream("14000".getBytes()));
        outputView.outputIssuingLotteryTicket();
    }
}