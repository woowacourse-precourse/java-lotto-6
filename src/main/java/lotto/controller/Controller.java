package lotto.controller;

import java.util.List;
import lotto.constants.Constants;
import lotto.domain.Customer;
import lotto.domain.WinningLotto;
import lotto.utils.Utils;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    Customer customer;
    LottoController lottoController =  new LottoController();
    InputView inputView = new InputView();
    InputValidator inputValidator = new InputValidator();
    OutputView outputView = new OutputView();
    WinningLotto winningLotto;


    public void playLotto() {
        purchaseLotto();
        setWinningLotto();
    }

    private void purchaseLotto() {
        while (true) {
            try {
                String lottoPrice = inputView.showInputMention();
                int purchasedTicketPrice = inputValidator.checkAll(lottoPrice);
                int purchasedTicketNumber = Utils.figureOutQuotient(purchasedTicketPrice, Constants.LOTTO_PRICE);
                customer = new Customer(purchasedTicketPrice,purchasedTicketNumber);
                purchaseAllLotto(customer.getNumberOfLottoTicket());
                outputView.showLottos(customer.getLottos(customer));
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
    private void setWinningLotto(){
        while (true){
            try {
                List<Integer> winningNumbers = inputValidator.checkWinningNumber(inputView.generalWinningNumber());
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}