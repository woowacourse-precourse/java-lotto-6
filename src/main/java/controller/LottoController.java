package controller;

import mapper.LottoMapper;
import service.LottoService;
import view.InputView;
import view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMapper lottoMapper = new LottoMapper(new LottoService());

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void buyTickets() {
        outputView.inputPurchaseAmount();
        int ticketCount = lottoMapper.buyTickets(inputView.purchaseAmount());
        outputView.buyLottoes(ticketCount);
        outputView.lottoTickets(lottoMapper.getTickets());
    }

    public void drawLotto() {
        outputView.inputWinningNumber();
        lottoMapper.setWinningNumber(inputView.winningNumbers());
        outputView.inputBonusNumber();
        lottoMapper.setBonusNumber(inputView.bonusNumber());
    }

    public void printWinningStatistics() {
        outputView.winningStatistics(lottoMapper.getResult());
    }
}
