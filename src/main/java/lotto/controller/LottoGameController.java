package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.message.GameMessage.*;
import static lotto.message.LottoMessage.LOTTO_COUNT;

public class LottoGameController {

    private final OutputView output;
    private final InputView input;

    public LottoGameController(OutputView output, InputView input) {
        this.output = output;
        this.input = input;
    }

    public void start() {
        int purchaseCost = inputLottoPurchaseCost();
        printLottoNumbers(purchaseCost);
        inputWinningNumbers();
        inputBonusNumbers();
        printWinningStatistics();
    }

    private int inputLottoPurchaseCost() {
        output.printMessage(ASK_FOR_PURCHASE_COST);
        return 8;
    }

    private void printLottoNumbers(int purchaseCost) {
        output.printLottoCount(LOTTO_COUNT,purchaseCost);
    }

    private List<Integer> inputWinningNumbers() {
        output.printMessage(ASK_FOR_WINNING_NUMBER);
        return null;
    }

    private int inputBonusNumbers() {
        output.printMessage(ASK_FOR_BONUS_NUMBER);
        return 0;
    }

    private void printWinningStatistics() {
        output.printMessage(WINNING_STATISTICS);
    }


}
