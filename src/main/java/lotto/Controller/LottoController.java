package lotto.Controller;

import lotto.domian.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    private List<List<Integer>> boughtLottos = new ArrayList<>();
    private Lotto lotto;
    private List<Integer> numbers;
    private WinningCheck winningCheck = new WinningCheck();
    public Map<String, Integer> rankingCount;
    private int bonusNumber;

    public void run() {
        start();
    }

    private void start() {
        long lottoAmount = inputLottoAmount();
        OutputView.printLottoAmount(lottoAmount);

        printBoughtLotto(lottoAmount);
        printWinningAndBonusNumber();

        printWinningStatistic();
        printYield();

    }

    private long inputLottoAmount() {
        LottoAmount lottoAmountCount = new LottoAmount(InputView.inputAmount());
        return lottoAmountCount.calculateLottoAmount();
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
        System.out.println();
        numbers = InputView.inputWinningNumbers();
        System.out.println();
        bonusNumber = InputView.inputBonusNumber();
        rankingCount = winningCheck.checkCount(boughtLottos, numbers, bonusNumber);
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
        System.out.println();
        OutputView.printYield();
    }
}
