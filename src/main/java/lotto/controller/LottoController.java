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
        Lottos lottos = LottoStore.publishLotto(Integer.parseInt(purchasePrice));

        System.out.println(PrintMessages.INPUT_WINNING_NUMBER);
        String winningNumberInput = InputHandler.winningNumber();
        List<String> beforeWinningNumbers = Arrays.stream(winningNumberInput.split(SEPARATOR)).toList();

        System.out.println(PrintMessages.INPUT_BONUS_NUMBER);
        String bonusNum = InputHandler.bonusNumber(beforeWinningNumbers);
        WinningNumber winningNumber = new WinningNumber(toIntegers(beforeWinningNumbers), Integer.parseInt(bonusNum));

        List<LottoRank> lottoRanks = lottos.checkRank(winningNumber);

        for (LottoRank lottoRank : lottoRanks) {
            System.out.println(lottoRank);
        }
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
