package lotto.service;

import lotto.domain.LottoTicket;
import lotto.exception.PurchaseExceptionMessage;
import lotto.view.InputView;

public class LottoService {
    private final LottoTicket lottoTicket = new LottoTicket();

    public int displayPurchase() {
        InputView.printPurchasePrompt();

        while (true) {
            try {
                String purchaseAmountView = InputView.getPurchaseAmountView();

                // 숫자인지 검증
                PurchaseExceptionMessage.validateIsNumeric(purchaseAmountView);

                int price = Integer.parseInt(purchaseAmountView);

                // 1,000단위인지 검증
                PurchaseExceptionMessage.validatePurchaseAmount(price);

                return price;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
