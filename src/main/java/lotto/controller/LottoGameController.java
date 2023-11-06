package lotto.controller;

import java.util.Map;
import lotto.constant.LottoGrade;
import lotto.model.Lottos;
import lotto.model.MoneyToBuy;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private Lottos lottos;
    private MoneyToBuy moneyToBuy;
    private WinningLotto winningLotto;


    private OutputView outputView;
    private InputView inputView;

    public LottoGameController() {
        lottos = new Lottos();
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void run() {
        moneyToBuy = inputView.requestMoneyToBuy();
        this.winningLotto = inputView.requestWinningLotto();

        lottos.generate(moneyToBuy.getLottosNumber());

        outputView.printNumberOfBoughtLottos(moneyToBuy.getLottosNumber());
        outputView.printLottos(lottos);

        Map<LottoGrade, Integer> grades = lottos.calculateLottoGrades(winningLotto);

        outputView.printPrizeResults(grades);
        outputView.printRateOfReturn(grades, moneyToBuy);
    }
}
