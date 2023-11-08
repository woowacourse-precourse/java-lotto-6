package lotto.controller;

import static lotto.domain.Lotto.createLotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.view.UI;

public class LottoController {

    public void start() {
        String lottoPurchaseRequest = lottoOrderRequest();
        LottoStore lottoStore = buyLottoTicketRequest(lottoPurchaseRequest);
        respondLottoTicketsHistory(lottoStore.getUserLottoTickets());
        Lotto winningLotto = createWinningNumbers();
        int bonusNumber = createBonusNumber(winningLotto);
        lottoStore.noticeWinningNumber(winningLotto, bonusNumber);
        String lottoReceipt = lottoStore.makeLottoReceipt();
        UI.displayLottoReceipt(lottoReceipt);
    }

    public LottoStore buyLottoTicketRequest(String lottoPurchaseRequest) {

        LottoStore lottoStore = new LottoStore();
        lottoStore.buyLottoTickets(lottoPurchaseRequest);
        return lottoStore;
    }

    public void respondLottoTicketsHistory(List<Lotto> LottoTickets) {
        UI.displayLottoTicketsHistory(LottoTickets);
    }

    public String requestInputWinningNumbers() {
        return UI.InputWinningNumbers();
    }

    public String requestBonusNumber() {
        return UI.InputBonusNumber();
    }
}
