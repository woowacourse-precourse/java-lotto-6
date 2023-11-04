package lotto.controller;

import lotto.domain.User;
import lotto.dto.LottoTicketsDTO;
import lotto.utility.GameUtility;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    private LottoGame() {}

    public static void run() {
        int payment = getPaymentAndValidate();
        User user = GameUtility.buyTickets(payment);

        OutputView.printLottoTickets(
                new LottoTicketsDTO(
                        user.getLottoTickets().size(),
                        user.getLottoTickets())
        );
    }

    private static int getPaymentAndValidate() {
        String paymentString;
        int payment;
        try {
            OutputView.printInputPurchaseAmount();
            paymentString = InputView.receiveUserInput();

            Validator.isPrimeNumber(paymentString);
            Validator.isPositiveNumber(paymentString);
            Validator.isUnitsOfLottoPrice(paymentString);
            payment = Integer.parseInt(paymentString);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            payment = getPaymentAndValidate();
        }

        return payment;
    }



}

