package lotto.controller;

import lotto.constants.Constants;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.Order;
import lotto.utils.Utils;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    Customer customer;
    LottoController lottoController =  new LottoController();
    InputView inputView = new InputView();
    InputValidator inputValidation = new InputValidator();
    OutputView outputView = new OutputView();


    public void playLotto() {
        purchaseLotto();
    }

    public void purchaseLotto() {
        while (true) {
            try {
                String lottoPrice = inputView.showInputMention();
                int purchasedTicketPrice = inputValidation.checkAll(lottoPrice);
                int purchasedTicketNumber = Utils.figureOutQuotient(purchasedTicketPrice, Constants.LOTTO_PRICE);
                customer = new Customer(purchasedTicketPrice,purchasedTicketNumber);
                purchaseAllLotto(customer.getNumberOfLottoTicket());
                outputView.show(customer.getLottos(customer));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private void purchaseAllLotto(int count){
        for (int i = 0; i < count; i++) {
            customer.purchaseLotto(lottoController.GenerateLotto());
        }
    }
}