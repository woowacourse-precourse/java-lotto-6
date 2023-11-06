package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.LottoGrade;
import lotto.Prize;
import lotto.model.Lotto;
import lotto.model.MoneyToBuy;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputMessage;
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
        printBoughtLottos();
        printLottoGrades();
    }

    private void generateLottos() {
        for (int i = 0; i < moneyToBuy.getLottosSize(); i++) {
            lottos.add(Lotto.generateLotto());
        }
    }

    private void printBoughtLottos() {
        System.out.printf(OutputMessage.BUY_LOTTO_RESULT.getMessage() + "\n", moneyToBuy.getLottosSize());
        lottos.forEach(lotto -> System.out.println(lotto));
    }

    private void printLottoGrades() {
        int threeMatch = 0;
        int fourMatch = 0;
        int fiveMatch = 0;
        int fiveAndBonusMatch = 0;
        int sixMatch = 0;

        for (int i = 0; i < lottos.size(); i++) {
            LottoGrade lottoGrade = winningLotto.determineLottoGrade(lottos.get(i));
            if (lottoGrade == LottoGrade.SIX_MATCH) {
                sixMatch += 1;
            } else if (lottoGrade == LottoGrade.FIVE_AND_BONUS_MATCH) {
                fiveAndBonusMatch += 1;
            } else if (lottoGrade == LottoGrade.FIVE_MATCH) {
                fiveMatch += 1;
            } else if (lottoGrade == LottoGrade.FOUR_MATCH) {
                fourMatch += 1;
            } else if (lottoGrade == LottoGrade.THREE_MATCH) {
                threeMatch += 1;
            }
        }

        System.out.printf(OutputMessage.LOTTO_GRADE_RESULT.getMessage(), threeMatch, fourMatch, fiveMatch,
                fiveAndBonusMatch, sixMatch);
        printRateOfReturn(threeMatch, fourMatch, fiveMatch,
                fiveAndBonusMatch, sixMatch);
    }

    private void printRateOfReturn(int threeMatch, int fourMatch, int fiveMatch, int fiveAndBonusMatch, int sixMatch) {
        Integer totalIncome = Prize.getTotalIncome(threeMatch, fourMatch, fiveMatch,
                fiveAndBonusMatch, sixMatch);
        Double rateOfReturn = totalIncome.doubleValue() / moneyToBuy.getValue() * 100;
        System.out.printf(OutputMessage.RATE_OF_RETURN.getMessage(), String.format("%.1f", rateOfReturn));
    }
}
