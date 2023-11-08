package lotto.controller;

import static lotto.domain.Lotto.createLotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.view.UI;

public class LottoController {

    public void start() {
        LottoStore lottoStore = buyLottoTicketRequest();
        respondLottoTicketsHistory(lottoStore.getUserLottoTickets());
        Lotto winningLotto = createWinningNumbers();
        int bonusNumber = createBonusNumber(winningLotto);
        lottoStore.noticeWinningNumber(winningLotto, bonusNumber);
        String lottoReceipt = lottoStore.makeLottoReceipt();
        UI.displayLottoReceipt(lottoReceipt);
    }


    public LottoStore buyLottoTicketRequest() {
        while (true) {
            try {
                String lottoPurchaseRequest = UI.sendLottoPurchaseRequest();
                LottoStore lottoStore = new LottoStore();
                lottoStore.buyLottoTickets(lottoPurchaseRequest);
                return lottoStore;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto createWinningNumbers() {
        while (true) {
            try {
                String InputWinningNumbers = requestInputWinningNumbers();
                return createLotto(InputWinningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int createBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                return winningLotto.createBonusNumber(requestBonusNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
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
