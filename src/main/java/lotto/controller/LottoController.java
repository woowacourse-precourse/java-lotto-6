package lotto.controller;

import lotto.Lotto;
import lotto.service.InputMoneyService;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {


    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator;


    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = new Validator();
    }

    public void start() {
        Long money = inputMoney(new InputMoneyService());


    }

    private Long inputMoney(InputMoneyService inputMoneyService) {
        try {
            inputMoneyService.getRightMoneyProcess(validator, inputView.inputMoney());
            return Long.parseLong(inputView.inputMoney());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputMoney(inputMoneyService);
        }
    }
}
