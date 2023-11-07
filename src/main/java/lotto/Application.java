package lotto;

import lotto.controllers.DongHangLottery;
import lotto.controllers.LottoStoreManager;
import lotto.views.LottoView;

import static lotto.views.MessageManager.getLottoNumberPromptMessage;
import static lotto.views.MessageManager.getPurchaseAmountPromptMessage;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        getPurchaseAmountPromptMessage();

        LottoStoreManager controller = new LottoStoreManager();
        LottoView view = new LottoView();


        System.out.println();

        view.lottoTicketCountView(controller.getLottoTicketCount());
        controller.displayLottoTicketsNumber();

        System.out.println();
        getLottoNumberPromptMessage();
        DongHangLottery lottoMatcher = new DongHangLottery();
    }
}