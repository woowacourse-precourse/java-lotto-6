package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoGrade;
import lotto.model.Lotto;
import lotto.model.MoneyToBuy;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private List<Lotto> lottos;
    private MoneyToBuy moneyToBuy;
    private WinningLotto winningLotto;


    private OutputView outputView;
    private InputView inputView;

    public LottoGameController() {
        lottos = new ArrayList<Lotto>();
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void run() {
        moneyToBuy = inputView.requestMoneyToBuy();
        this.winningLotto = inputView.requestWinningLotto();

        generateLottos();

        outputView.printNumberOfBoughtLottos(moneyToBuy.getLottosSize());
        outputView.printLottos(lottos);

        Map<LottoGrade, Integer> grades = calculateLottoGrades();

        outputView.printPrizeResults(grades);
        outputView.printRateOfReturn(grades, moneyToBuy);
    }

    private void generateLottos() {
        for (int i = 0; i < moneyToBuy.getLottosSize(); i++) {
            lottos.add(Lotto.generateLotto());
        }
    }

    private Map<LottoGrade, Integer> calculateLottoGrades() {
        Map<LottoGrade, Integer> grades = new HashMap<LottoGrade, Integer>();
        for (int i = 0; i < lottos.size(); i++) {
            LottoGrade lottoGrade = winningLotto.determineLottoGrade(lottos.get(i));
            grades.put(lottoGrade, grades.getOrDefault(lottoGrade, 0) + 1);
        }

        return grades;
    }
}
