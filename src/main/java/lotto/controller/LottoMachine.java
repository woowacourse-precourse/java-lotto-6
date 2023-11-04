package lotto.controller;

import lotto.domain.lottery.Lottos;
import lotto.domain.validator.Validator;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.view.constants.PrintMessage.PRINT_GAME_START;

public class LottoMachine {
    public static void init() {
        OutputView.printMessage(PRINT_GAME_START);
        int payment = readPayment();
        Lottos lottoTickets = Lottos.publishTickets(payment);
    }

    private static int readPayment() {
        try {
            int purchasePrice = InputView.readPayment();
            Validator.validateUnitPrice(purchasePrice);

            return purchasePrice;
        } catch (LottoException exception) {
            return readPayment();
        }
    }
}
