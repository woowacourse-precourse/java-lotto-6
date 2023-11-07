package lotto.controller;

import lotto.model.LottoAmount;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;
    private LottoAmount lottoAmount;

    public LottoController() {
        inputView = new InputView();

    }

    public void start() {
        int lottoTicketCount = inputLottoAmount();

    }

    public int inputLottoAmount() {
        while (true) {
            try {
                lottoAmount = new LottoAmount(inputView.inputAmount());
                return lottoAmount.getlottoTicketCount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
