package lotto;

import lotto.view.UserInputView;
import lotto.view.UserOutputView;

public class RunLotto {

    public static void runLotto(){
        UserOutputView.getInstance().outputPurchaseAmount();
        UserInputView.getInstance().inputPurchaseAmount();

        UserOutputView.getInstance().getBuyLottoTicketsNum();
        UserOutputView.getInstance().getBuyLottoTickets();

        UserOutputView.getInstance().outputWinningNums();
        UserInputView.getInstance().inputWinningNums();

        UserOutputView.getInstance().outputBonusNum();
        UserInputView.getInstance().inputBonusNum();

        UserOutputView.getInstance().winningStatistics();
        UserOutputView.getInstance().winningStatisticsResult();
        UserOutputView.getInstance().winningLottoRateResult();




    }
}
