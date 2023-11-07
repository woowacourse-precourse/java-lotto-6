package lotto.controller;

import lotto.model.LottoAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private LottoAmount lottoAmount;
    private OutputView outputView;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        int lottoTicketCount = inputLottoAmount();
        outputView.printlottoTicketCount(lottoTicketCount);
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
