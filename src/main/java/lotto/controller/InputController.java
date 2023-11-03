package lotto.controller;

import lotto.constants.Constants;
import lotto.utils.Utils;
import lotto.validation.InputValidation;
import lotto.view.InputView;

public class InputController {
    InputView inputView = new InputView();
    InputValidation inputValidation = new InputValidation();
    Utils utils = new Utils();
    private int purchasedTicketNumber;

    public void playLotto() {
        purchaseLotto();
    }

    public void purchaseLotto() {
        while (true) {
            try {
                String lottoPrice = inputView.showInputMention();
                int purchasedTicketPrice = inputValidation.checkAll(lottoPrice);
                utils.figureOutQuotient(purchasedTicketPrice, Constants.LOTTO_PRICE);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}