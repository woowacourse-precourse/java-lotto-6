package controller;

import mapper.LottoMapper;
import view.InputView;
import view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMapper lottoMapper = new LottoMapper();

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void buyTickets() {
        int ticketCount = lottoMapper.buyTickets(inputView.purchaseAmount());
        outputView.buyLottoes(ticketCount);
        outputView.lottoTickets(lottoMapper.getTickets());
    }

    public void drawLotto() {

    }

    public void printWinningStatistics() {

    }
}
