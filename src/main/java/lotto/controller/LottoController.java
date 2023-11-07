package lotto.controller;

import java.util.List;
import java.util.ArrayList;
import lotto.model.Budget;
import lotto.model.Lotto;
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
        issueLottos(this.budget);
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

    private void issueLottos(Budget budget) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < budget.getLottoCount(); i++) {
            lottos.add(lottoService.createLotto());
        }
        user = new User(budget.getLottoCount(), lottos);
    }


}
