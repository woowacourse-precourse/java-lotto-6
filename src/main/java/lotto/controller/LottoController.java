package lotto.controller;


import lotto.View.ErrorMessageView;
import lotto.View.InputView;
import lotto.model.LottoAmount;

public class LottoController {

    public void start() {
        LottoAmount amount = inputAmount();
    }

    private LottoAmount inputAmount() {
        try {
            String LottoAmount = InputView.inputLottoAmount();
            return new LottoAmount(LottoAmount);
        } catch (IllegalArgumentException e) {
            ErrorMessageView.printErrorWrongAmount();
            return inputAmount();
        }
    }
}
