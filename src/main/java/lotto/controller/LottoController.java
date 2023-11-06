package lotto.controller;

import java.util.List;
import lotto.domain.Judgement;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.util.WinningLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Judgement judgement;

    public LottoController(InputView inputView, OutputView outputView, Judgement judgement) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.judgement = judgement;
    }

    public void run() {
        Money money = getMoneyFromUser();
        Lottos lottos = new Lottos(money.getTryNumber());
        displayBuyLottos(lottos, money.getTryNumber());
        WinningLotto winningLotto = getWinningLottoNumber();
        addBonusNumber(winningLotto, getBonusNumber());
        judgement.checkLottoNumber(lottos, winningLotto);
        displayWinningCount(lottos, money);
    }

    private Money getMoneyFromUser() {
        try {
            String input = requestMoneyFromUser();
            return new Money(input);
        } catch (IllegalArgumentException e) {
            outputView.displayERRORMESSAGE(e.getMessage());
            return getMoneyFromUser();
        }
    }

    private String requestMoneyFromUser() {
        outputView.displayRequestMoney();
        return inputView.requestMoneyFromUser();
    }

    private void displayBuyLottos(Lottos lottos, int tryNumber) {
        outputView.displayBuyLottoCount(lottos, tryNumber);
        System.out.println();
    }

    private WinningLotto getWinningLottoNumber() {
        try {
            String WinningNumberFromUser = requestWinningNumberFromUser();
            return new WinningLotto(WinningLottoGenerator.generateLottoNumber(WinningNumberFromUser));
        } catch (IllegalArgumentException e) {
            outputView.displayERRORMESSAGE(e.getMessage());
            return getWinningLottoNumber();
        }

    }

    private String requestWinningNumberFromUser() {
        outputView.displayRequestWinningNumber();
        return inputView.requestWinningLottoFromUser();
    }

    private void addBonusNumber(WinningLotto winningLotto, String bonus_number) {
        try {
            winningLotto.addBonusNumber(bonus_number);
        } catch (IllegalArgumentException e) {
            outputView.displayERRORMESSAGE(e.getMessage());
            winningLotto.removeBonusNumber();
            addBonusNumber(winningLotto, getBonusNumber());
        }
    }

    private String getBonusNumber() {
        outputView.displayRequestBonusNumber();
        return inputView.requestBonusNumberFromUser();
    }

    private void displayWinningCount(Lottos lottos, Money money) {
        outputView.displayResult();
        List<Integer> ranks = judgement.judgeAllLottoRank(lottos);
        outputView.displayWinningLotto(ranks);
        float earningRate = judgement.calculateEarningRate(ranks, money);
        outputView.displayEarningRate(earningRate);
    }

}
