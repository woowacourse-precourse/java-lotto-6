package lotto.controller;

import lotto.domain.LotteryMessageBuilder;
import lotto.domain.lottery.*;
import lotto.domain.validation.validator.Validator;
import lotto.view.OutputView;
import lotto.view.InputView;

import static lotto.controller.LotteryGameController.*;
import static lotto.domain.constants.LottoConstraint.LOTTO_PRICE;
import static lotto.domain.validation.ExceptionMessage.EXCEPTION_MESSAGE_PREFIX;
import static lotto.domain.validation.ExceptionMessage.NUMBER_FORMAT_EXCEPTION;

public class PurchaseController {

    private final InputView inputView = new InputView();
    private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private final LotteryMessageBuilder lotteryMessageBuilder = new LotteryMessageBuilder();
    private final Validator validator = new Validator();
    void purchaseStage() {
        OutputView.requestPurchaseAmountMessage();
        purchaseAmount = amountOfLottos();

        purchaseLotto(purchaseAmount);
        OutputView.printNewLine();
        OutputView.returnLottery(lottoAmount,
                lotteryMessageBuilder.returnLottoList(purchasedLotto.getLottos()));
    }

    private int amountOfLottos() {
        String input = inputView.returnInput();

        if (!validator.isInputInteger(input)) {
            System.out.println(EXCEPTION_MESSAGE_PREFIX.getMessage() + NUMBER_FORMAT_EXCEPTION.getMessage());
            return amountOfLottos();
        }

        try {
            validator.isPurchaseAmountPositive(input);
            validator.isPurchaseAmountDividedUp(input);
        } catch (IllegalArgumentException e) {
            System.out.println(EXCEPTION_MESSAGE_PREFIX.getMessage() + NUMBER_FORMAT_EXCEPTION.getMessage());
            return amountOfLottos();
        }

        return Integer.parseInt(input);
    }

    private void purchaseLotto(int purchaseAmount) {
        lottoAmount = purchaseAmount / LOTTO_PRICE.getValue();

        for (int i = 0; i < lottoAmount; i++) {
            purchasedLotto.addLotto(new Lotto(lottoNumberGenerator.generateSortedLottoNumber()));
        }
    }
}
