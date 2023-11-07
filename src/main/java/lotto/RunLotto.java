package lotto;

import lotto.view.UserInputView;
import lotto.view.UserOutputView;

public class RunLotto {

    public static void runLotto(){
        UserOutputView.outputPurchaseAmount();
        UserInputView.inputPurchaseAmount();

        UserOutputView.getBuyLottoTickets();
        UserInputView.putWinningNums();
        UserInputView.putBonusNum();

    }
}
