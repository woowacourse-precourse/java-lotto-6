package lotto.controller;

import lotto.model.LottoAmount;
import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoAmount lottoAmount;

    private Lottos lottos;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        int lottoTicketCount = inputLottoAmount();
        outputView.printLottoTicketCount(lottoTicketCount);
        lottos = new Lottos(lottoTicketCount);
        outputView.printLottos(lottos);
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
