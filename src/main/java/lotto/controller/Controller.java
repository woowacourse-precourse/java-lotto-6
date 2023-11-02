package lotto.controller;

import lotto.view.InputView;
import lotto.utility.Utility;
import lotto.validation.Validation;
import lotto.model.Model;

public class Controller {
    public Controller() {
        InputView inputView = new InputView();
        Utility utility = new Utility();
        Validation validation = new Validation();
        Model model = new Model();

        String paymentInput = inputView.getPayment();
        int payment = utility.parseInt(paymentInput);
        validation.validateUnit(payment);

        model.buyLotto(payment);



    }
}
