package lotto.controller;


import lotto.domain.UserAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        UserAmount userAmount = InputView.getUserAmount();
        int issueAbleCount = userAmount.calculateIssueAbleCount();
        OutputView.printIssueAbleCount(issueAbleCount);
    }

}

