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

        double rate = getRateOfReturn(lottoRanks, purchasePrice);
    }

    private void purchaseLotto() {
        System.out.println(PrintMessages.INPUT_PRICE);
        purchasePrice = InputHandler.purchasePrice();
        lottos = LottoStore.publishLotto(Integer.parseInt(purchasePrice));
    }

    private void inputWinningNumber() {
        System.out.println(PrintMessages.INPUT_WINNING_NUMBER);
        String winningNumberInput = InputHandler.winningNumber();
        beforeWinningNumbers = Arrays.asList(winningNumberInput.split(SEPARATOR));
    }

    private void inputBonusNumber() {
        System.out.println(PrintMessages.INPUT_BONUS_NUMBER);
        String bonusNum = InputHandler.bonusNumber(beforeWinningNumbers);
        winningNumber = new WinningNumber(toIntegers(beforeWinningNumbers), Integer.parseInt(bonusNum));
    }

    private void checkLottoRank() {
        lottoRanks = lottos.checkRank(winningNumber);
    }

    private double getRateOfReturn(List<LottoRank> lottoRanks, String purchasePrice) {
        int totalReward = lottoRanks.stream()
                .mapToInt(LottoRank::getReward)
                .sum();

        return totalReward / Double.parseDouble(purchasePrice);
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
