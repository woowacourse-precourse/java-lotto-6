package lotto.controller;

import lotto.model.LottoAmount;
import lotto.model.Lottos;
import lotto.service.Service;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Service service;
    private LottoAmount lottoAmount;

    private Lottos lottos;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
        service = new Service();
    }

    public void start() {
        int lottoTicketCount = inputLottoAmount();
        outputView.printLottoTicketCount(lottoTicketCount);
        lottos = createLottos(lottoTicketCount);
        outputView.printLottos(lottos);
        inputView.inputWinningNumbers();
    }

    private int inputLottoAmount() {
        while (true) {
            try {
                lottoAmount = new LottoAmount(inputView.inputAmount());
                return lottoAmount.getlottoTicketCount();
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private Lottos createLottos(int lottoTicketCount) {
        while (true) {
            try {
                return new Lottos(service.createLottos(lottoTicketCount));
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }


}
