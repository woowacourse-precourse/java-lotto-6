package lotto.controller;

import lotto.model.PurchaseCost;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.message.GameMessage.ASK_FOR_PURCHASE_COST;

public class LottoGameController {

    private final OutputView output;
    private final InputView input;

    public LottoGameController(OutputView output, InputView input) {
        this.output = output;
        this.input = input;
    }

    public void start() {
        PurchaseCost purchaseCost = inputLottoPurchaseCost();
//        printLottoNumbers();
//        inputWinningNumbers();
//        inputBonusNumbers();
//        printWinningStatistics();
    }

    private PurchaseCost inputLottoPurchaseCost() {

        while (true) {
            try {
                String money = inputPurchaseCost();
                return new PurchaseCost(money);
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e);
            }
        }
    }

    private String inputPurchaseCost() {
        output.printMessage(ASK_FOR_PURCHASE_COST);
        return input.purchaseCost();
    }
//
//
//
//    private List<Integer> inputWinningNumbers() {
//        output.printMessage(ASK_FOR_WINNING_NUMBER);
//        return null;
//    }
//
//    private int inputBonusNumbers() {
//        output.printMessage(ASK_FOR_BONUS_NUMBER);
//        return 0;
//    }
//
//    private void printWinningStatistics() {
//        output.printMessage(WINNING_STATISTICS);
//    }


}
