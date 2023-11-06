package lotto;

import lotto.controllers.LottoStoreManager;
import lotto.views.LottoView;

import static lotto.views.MessageManager.getPurchaseAmountPromptMessage;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        getPurchaseAmountPromptMessage();

        LottoStoreManager controller = new LottoStoreManager();
        LottoView view = new LottoView();

        controller.purchaseController();
        System.out.println();

        controller.lottoMachine();
        view.lottoTicketCountView(controller.getLottoTicketCount());

    }
}
