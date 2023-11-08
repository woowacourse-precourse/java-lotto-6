package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoSetUp;
import lotto.model.ResultCheck;
import lotto.view.View;

import java.util.ArrayList;

public class LottoGameController {
    static ArrayList<ArrayList<Integer>> lottos;
;
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
        View.printResultStatistics();
    }
}
