package lotto.controller;

import lotto.constant.LottoRank;
import lotto.constant.PrintMessages;
import lotto.model.Lotto;
import lotto.model.LottoStore;
import lotto.model.Lottos;
import lotto.model.WinningNumber;
import lotto.view.InputHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {
    private static final String SEPARATOR = ",";
    public void run() {
        System.out.println(PrintMessages.INPUT_PRICE);
        String purchasePrice = InputHandler.purchasePrice();
        final Lottos lottos = LottoStore.publishLotto(Integer.parseInt(purchasePrice));

        System.out.println(PrintMessages.INPUT_WINNING_NUMBER);
        String winningNumberInput = InputHandler.winningNumber();
        final List<String> beforeWinningNumbers = Arrays.stream(winningNumberInput.split(SEPARATOR)).toList();

        System.out.println(PrintMessages.INPUT_BONUS_NUMBER);
        String bonusNum = InputHandler.bonusNumber(beforeWinningNumbers);
        final WinningNumber winningNumber = new WinningNumber(toIntegers(beforeWinningNumbers), Integer.parseInt(bonusNum));

        final List<LottoRank> lottoRanks = lottos.checkRank(winningNumber);
        double rate = getRateOfReturn(lottoRanks, purchasePrice);
        System.out.println(rate);
    }

    private double getRateOfReturn(List<LottoRank> lottoRanks, String purchasePrice) {
        int totalReward = 0;
        double rateOfReturn;

        for (LottoRank lottoRank : lottoRanks) {
            totalReward += lottoRank.getReward();
        }

        rateOfReturn = totalReward / Double.parseDouble(purchasePrice);

        return rateOfReturn;
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
