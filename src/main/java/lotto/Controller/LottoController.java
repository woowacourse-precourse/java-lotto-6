package lotto.Controller;

import lotto.domian.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    private List<List<Integer>> boughtLottos = new ArrayList<>();
    private List<Integer> numbers;
    private WinningCheck winningCheck = new WinningCheck();
    public Map<String, Integer> rankingCount;
    private Lotto lotto;
    private int bonusNumber;
    private long lottoAmount;

    public void run() {
        start();
    }

    private void start() {
        lottoAmount = inputLottoAmount();
        OutputView.printLottoAmount(lottoAmount);

        printBoughtLotto(lottoAmount);
        printWinningAndBonusNumber();

        printWinningStatistic();
        printYield();
    }

    private long inputLottoAmount() {
        LottoAmount lottoAmountCount = new LottoAmount(InputView.inputAmount());
        long amount = lottoAmountCount.getLottoAmount();
        return lottoAmountCount.calculateLottoAmount((int) amount);
    }

    private void printBoughtLotto(long lottoAmount) {
        long count = lottoAmount;
        while (count-- > 0) {
            BoughtLotto boughtLotto = new BoughtLotto();
            boughtLottos.add(boughtLotto.generateLottoNumbers());
        }
        for (List<Integer> lotto : boughtLottos) {
            System.out.println(lotto);
        }
    }

    private void printWinningAndBonusNumber() {
        try {
            System.out.println();
            lotto = new Lotto(InputView.inputWinningNumbers());
            numbers = lotto.getLotto();
            System.out.println();
            bonusNumber = lotto.bonusNumber(InputView.inputBonusNumber());
            rankingCount = winningCheck.checkCount(boughtLottos, numbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            printWinningAndBonusNumber();
        }
    }

    private void printWinningStatistic() {
        System.out.println();
        OutputView.printStatisicsString();
        for (WinningTable winningTable : WinningTable.values()) {
            if (winningTable.getCorrectNumberCount() != 0)
            System.out.println(winningTable.getMessage() + rankingCount.get(winningTable.name()) + "개");
        }
    }

    private void printYield() {
        double sum = 0;
        for (WinningTable winningTable : WinningTable.values()) {
            sum += (long) rankingCount.get(winningTable.name()) * winningTable.getWinningAmount();
        }
        double yield = (sum * 100) / (lottoAmount * 1000);
        double roundYield = Math.round(yield * 100.0) / 100.0;
        System.out.println("총 수익률은 " + roundYield + "%입니다.");
    }
}
