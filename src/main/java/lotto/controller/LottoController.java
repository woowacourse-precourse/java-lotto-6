package lotto.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Budget;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;
import lotto.domain.Policy;
import lotto.domain.Result;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.service.ResultService;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoController {
    private final LottoService lottoService;
    private final ResultService resultService;

    private User user;

    private Budget budget;
    private Lotto winningLotto;
    private BonusNumber bonusNumber;
    private LottoAnswer lottoAnswer;


    public LottoController(LottoService lottoService, ResultService resultService) {
        this.lottoService = lottoService;
        this.resultService = resultService;
    }

    public void start() {
        payMoney();
        issueLottos(this.budget);
        printStatus(this.user);
        readAnswer();
        printResult(this.user, this.lottoAnswer);
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

    private void printStatus(User user) {
        int amount = user.getPurchaseCount();
        List<Lotto> userLottos = user.getLottos();

        OutputView.printLottoStatusDescription(amount);
        for (Lotto lotto : userLottos) {
            List<Integer> row = lotto.getNumbers();
            List<Integer> sortedRow = new ArrayList<>(row);
            Collections.sort(sortedRow);
            OutputView.printLotto(sortedRow);
        }
    }

    private void readAnswer() {
        boolean configured = false;
        while (!configured) {
            configured = doReadAnswer();
        }
        configured = false;
        while (!configured) {
            configured = doReadBonus();
            try {
                lottoAnswer = new LottoAnswer(winningLotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                configured = false;
            }
        }
    }

    private boolean doReadAnswer() {
        OutputView.printAnswerInputDescription();

        try {
            String userInput = InputView.inputAnswer();
            winningLotto = lottoService.createLotto(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private boolean doReadBonus() {
        OutputView.printBounsInputDescription();

        try {
            int userInput = InputView.inputBonus();
            bonusNumber = new BonusNumber(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    private void printResult(User user, LottoAnswer lottoAnswer) {
        OutputView.printResultDescription();
        Result result = resultService.addRankResult(user, lottoAnswer);
        for (Policy p : result.getResults().keySet()) {
            if (p == Policy.FAIL) {
                continue;
            }
            OutputView.printEachRank(p.getMessage(), p.getMoney(), result.getResults().get(p));
        }
        OutputView.printProfitRate(resultService.getProfitRate(user, result));
    }
}
