package Controller;

import Model.User;
import Util.InputValidator;
import View.InputView;
import View.OutputView;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;
    private InputValidator inputValidator;
    private User user;


    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputValidator = new InputValidator();
        this.user = new User();
    }

    private int receiveUserMoneyAndGetAmount() {
        try {
            String inputAmount = inputView.getInputPurchaseAmount();
            return inputValidator.checkInputPurchaseAmount(inputAmount);
        } catch (Exception e) {
            outputView.printErrorMessage(e.getMessage());
            return receiveUserMoneyAndGetAmount();
        }
    }

    public void start() {
        int lottoAmount = receiveUserMoneyAndGetAmount();
        user.generateLottos(lottoAmount);
    }
}
