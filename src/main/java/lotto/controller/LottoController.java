package lotto.controller;

import lotto.model.Payment;
import lotto.utils.InputValidator;
import lotto.view.InputView;

public class LottoController {
    InputView inputView = new InputView();
    InputValidator inputValidator = new InputValidator();

    public void proceedLottos() {
        Payment userPayment = buyLottos();
    }

    private Payment buyLottos() {
        try {
            String lottoAmount = inputView.askPaymentAmount();
            String preprocessedLottoAmount = inputValidator.preprocessUserInput(lottoAmount);
            int validLottoAmount = inputValidator.convertInputToPaymentAmount(preprocessedLottoAmount);
            Payment payment = new Payment(validLottoAmount);
            return payment;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return buyLottos();
        }
    }
}
