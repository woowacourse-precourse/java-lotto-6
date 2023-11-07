package lotto;

import lotto.view.UserInputView;
import lotto.view.UserOutputView;

public class RunLotto {

    public static void runLotto(){
        UserOutputView.outputPurchaseAmount();
        UserInputView.inputPurchaseAmount();

        UserOutputView.getBuyLottoTicketsNum();
        UserOutputView.getBuyLottoTickets();

        UserOutputView.outputWinningNums();
        UserInputView.inputWinningNums();

        UserOutputView.outputBonusNum();
        UserInputView.inputBonusNum();



    }
}
