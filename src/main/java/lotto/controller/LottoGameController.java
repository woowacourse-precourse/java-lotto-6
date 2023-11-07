package lotto.controller;

import lotto.Generator.LottoGenerator;
import lotto.model.Lottos;
import lotto.model.PurchaseCost;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.message.GameMessage.ASK_FOR_PURCHASE_COST;
import static lotto.message.LottoMessage.LOTTO_COUNT;

public class LottoGameController {

    private final OutputView output;
    private final InputView input;
    private final LottoGenerator lottoGenerator;


    public LottoGameController(OutputView output, InputView input, LottoGenerator lottoGenerator) {
        this.output = output;
        this.input = input;
        this.lottoGenerator = lottoGenerator;
    }

    public void start() {
        PurchaseCost purchaseCost = inputLottoPurchaseCost();
        int lottoCount = purchaseCost.calculateLottoCount();
        Lottos puchaseLottos = lottoGenerator.generatePurchaseLottos(lottoCount);

        printPurchaseLottos(lottoCount, puchaseLottos);

//        inputWinningNumbers();
//        inputBonusNumbers();
//        printWinniㅍㅇㄴngStatistics();
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

    private void printPurchaseLottos(int lottoCount, Lottos lottos) {
        printPurchaseLottoCount(lottoCount);
        printSortedPurchaseLottos(lottos);
    }

    private void printSortedPurchaseLottos(Lottos lottos) {
        output.printPurchaseLottos(lottos);
    }

    private void printPurchaseLottoCount(int lottoCount) {
        output.printLottoCount(LOTTO_COUNT, lottoCount);
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
