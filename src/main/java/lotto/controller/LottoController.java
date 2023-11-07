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
        String InputWinningNumbers = requestInputWinningNumbers();
        Lotto winningLotto = createLotto(InputWinningNumbers);
        int bonusNumber = winningLotto.createBonusNumber(requestBonusNumber());
    }

    public String lottoOrderRequest() {
        return UI.sendLottoPurchaseRequest();
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
