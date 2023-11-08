package lotto.controller;

import lotto.model.LottoResult;
import lotto.model.LottoTickets;
import lotto.view.ResultView;
import lotto.view.UserInputView;

public class GameController {
    public static void run() {
        try {
            play();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private static void play() {
        LottoTickets lottoTickets = UserInputView.inputBuyAmount();
        ResultView.printLottoTickets(lottoTickets);
        LottoResult lottoResult = new LottoResult(UserInputView.inputWinningNumbers(),
                UserInputView.inputBonusNumber());
        ResultView.printWinningsResult(lottoTickets, lottoResult);
    }

}
