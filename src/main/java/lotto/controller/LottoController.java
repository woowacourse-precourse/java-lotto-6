package lotto.controller;


import lotto.View.ErrorMessageView;
import lotto.View.InputView;
import lotto.model.LottoAmount;
import lotto.model.LottoTickets;

public class LottoController {

    public void start() {
        LottoAmount amount = inputAmount();
        buyLotto(amount);
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

    private void buyLotto(LottoAmount amount) {
        amount.getLottoCount();
        LottoTickets lottoTickets = new LottoTickets(amount.getLottoCount());
    }
}
