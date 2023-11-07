package lotto.controller;

import lotto.model.Budget;
import lotto.model.Policy;
import lotto.model.User;
import lotto.service.LottoAnswerService;
import lotto.service.LottoService;
import lotto.service.ResultService;
import lotto.service.UserService;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoController {
    private LottoAnswerService lottoAnswerService;
    private LottoService lottoService;
    private ResultService resultService;
    private UserService userService;

    private User user;

    private Policy lottoPolicy;
    private Budget budget;


    public LottoController(
            LottoAnswerService lottoAnswerService,
            LottoService lottoService,
            ResultService resultService,
            UserService userService
    ) {
        this.lottoAnswerService = lottoAnswerService;
        this.lottoService = lottoService;
        this.resultService = resultService;
        this.userService = userService;
    }

    public void start() {
        payMoney();
    }

    private void payMoney() {
        boolean purchased = false;
        while (!purchased) {
            purchased = doPayMoney();
        }
    }

    private boolean doPayMoney() {
        OutputView.printBudgetInputDescription();
        int userMoney;

        try {
            userMoney = InputView.inputBudget();
            budget = new Budget(userMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


}
