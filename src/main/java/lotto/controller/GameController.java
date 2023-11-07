package lotto.controller;

import java.util.List;
import lotto.model.LottoTicket;
import lotto.view.GameResultOutputView;
import lotto.view.UserInputView;

public class GameController {
    public static void play() {
        LottoTicket lottoTicket = UserInputView.inputPurchaseAmount();
        GameResultOutputView.showLottoTickets(lottoTicket);
        List<Integer> winningNumber = UserInputView.inputWinningNumber();
        UserInputView.inputBonusNumber(winningNumber);
    }
}
