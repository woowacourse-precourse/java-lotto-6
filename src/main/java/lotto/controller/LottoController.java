package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.BoughtLotto;
import lotto.domain.LottoAmount;
import lotto.domain.WinningTable;
import lotto.domain.WinningCheck;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {
    private final int PERCENT = 100;
    private final int LOTTO_PRICE = 1000;
    private final double CONVERT_DOUBLE_CONSTANT = 10.0;
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
        printWinningNumber();
        printBounusNumber();
        calculateRankingCount();

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

    private void printWinningNumber() {
        try {
            System.out.println();
            lotto = new Lotto(InputView.inputWinningNumbers());
            numbers = lotto.getLotto();
        } catch (IllegalArgumentException e) {
            printWinningNumber();
        }
    }

    private void printBounusNumber() {
        try {
            System.out.println();
            bonusNumber = lotto.bonusNumber(InputView.inputBonusNumber());
        } catch (IllegalArgumentException e) {
            printBounusNumber();
        }
    }

    private void calculateRankingCount() {
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
        double sum = 0;
        for (WinningTable winningTable : WinningTable.values()) {
            sum += (long) rankingCount.get(winningTable.name()) * winningTable.getWinningAmount();
        }
        double yield = (sum * PERCENT) / (lottoAmount * LOTTO_PRICE);
        double roundYield = Math.round(yield * CONVERT_DOUBLE_CONSTANT) / CONVERT_DOUBLE_CONSTANT;

        DecimalFormat df = new DecimalFormat("#,###.0");
        System.out.println("총 수익률은 " + df.format(roundYield) + "%입니다.");
    }
}