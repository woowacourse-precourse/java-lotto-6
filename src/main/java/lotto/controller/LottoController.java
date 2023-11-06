package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constant.LottoRank;
import lotto.constant.PrintMessages;
import lotto.model.LottoStore;
import lotto.model.Lottos;
import lotto.model.WinningNumber;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class LottoController {
    private static final String SEPARATOR = ",";
    private String purchasePrice;
    private Lottos lottos;
    private WinningNumber winningNumber;
    private List<String> beforeWinningNumbers;
    private List<LottoRank> lottoRanks;

    public void run() {
        purchaseLotto();
        inputWinningNumber();
        inputBonusNumber();
        checkLottoRank();
        calcRateOfReturn();
    }

    private void purchaseLotto() {
        OutputHandler.printPurchaseInput();
        purchasePrice = InputHandler.purchasePrice();
        lottos = LottoStore.publishLotto(Integer.parseInt(purchasePrice));
        OutputHandler.printPurchaseHistory(lottos);
    }

    private void inputWinningNumber() {
        OutputHandler.printWinningNumberInput();
        String winningNumberInput = InputHandler.winningNumber();
        beforeWinningNumbers = Arrays.asList(winningNumberInput.split(SEPARATOR));
    }

    private void inputBonusNumber() {
        OutputHandler.printBonusNumberInput();
        String bonusNum = InputHandler.bonusNumber(beforeWinningNumbers);
        winningNumber = new WinningNumber(toIntegers(beforeWinningNumbers), Integer.parseInt(bonusNum));
    }

    private void checkLottoRank() {
        lottoRanks = lottos.checkRank(winningNumber);
        OutputHandler.printWinningStatsSign();
        OutputHandler.printWinningStats(lottoRanks);
    }

    private void calcRateOfReturn() {
        int totalReward = lottoRanks.stream()
                .mapToInt(LottoRank::getReward)
                .sum();
        double rateOfReturn = (totalReward / Double.parseDouble(purchasePrice)) * 100;
        OutputHandler.printRateOfReturn(rateOfReturn);
    }

    private List<Integer> toIntegers(List<String> beforeWinningNumbers) {
        List<Integer> afterWinningNumbers = new ArrayList<>();

        for (String winningNumber : beforeWinningNumbers) {
            int num = Integer.parseInt(winningNumber);
            afterWinningNumbers.add(num);
        }

        return afterWinningNumbers;
    }
}
