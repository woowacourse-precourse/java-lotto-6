package lotto.controller;

import lotto.domain.DomainConstants;
import lotto.domain.LottoTicket;
import lotto.view.input.AmountView;
import lotto.view.input.Input;
import lotto.view.output.LottoView;
import lotto.view.output.Output;

public class LottoController {

    private final LottoTicket lottoTicket;

    public LottoController() {
        this.lottoTicket = new LottoTicket();
    }

    public void buyLotto() {
        int amount = inputAmount();
        generateLottoTicket(amount);
        displayMyLotto();
    }

    public int inputAmount() {
        Input<Integer> amountInputView = new AmountView<>(Integer::parseInt);
        return amountInputView.getInput();
    }

    public void generateLottoTicket(int amount) {
        int lottoCount = calculateLottoTicket(amount);
        lottoTicket.createLottoTicket(lottoCount);
    }

    public void displayMyLotto() {
        Output lottoView = new LottoView(lottoTicket.getLottoTicket());
        lottoView.println();
        lottoView.getOutput();
    }

    private int calculateLottoTicket(int amount) {
        return (amount / DomainConstants.LOTTO_PRICE.getInt());
    }
}
