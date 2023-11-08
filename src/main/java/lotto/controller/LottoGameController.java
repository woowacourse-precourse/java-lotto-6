package lotto.controller;
import lotto.model.LottoSetUp;
import lotto.model.ResultCheck;
import lotto.view.View;

public class LottoGameController {
    public LottoGameController () {
        View.printStartMessage();
    }

    public void lottoGameFlow() {
        View.inputTotalCost();
        View.printNumberOfLotto();
        View.printlottos();
        View.inputWinningNumber();
        View.inputBonusNumber();
        LottoSetUp.winningNumberToInt();
        ResultCheck.setUpJudgeResult();
        ResultCheck.SetUpBonusChecker();
        ResultCheck.DeclarationLottoMatch();
        ResultCheck.benefitCheck();
        View.printResultStatistics();
    }
}
