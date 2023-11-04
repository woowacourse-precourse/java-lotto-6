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
        String payment = null;

        try {
            OutputView.printInputPurchaseAmount();
            payment = InputView.receiveUserInput();
            Validator.validatePurchaseAmount(payment);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getPaymentAndValidate();
        }

        return (Integer.parseInt(payment));
    }



}

