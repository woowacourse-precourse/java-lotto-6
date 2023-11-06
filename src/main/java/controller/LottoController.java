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
        int ticketCount;
        try {
            ticketCount = lottoMapper.buyTickets(inputView.purchaseAmount());
            outputView.buyLottoes(ticketCount);
            outputView.lottoTickets(lottoMapper.getTickets());
        } catch (Exception e) {
            outputView.exceptionMessage(e.getMessage());
            buyTickets();
        }
    }

    public void drawLotto() {
        inputWinningNumbers();
        inputBonusNumber();
    }

    private void inputWinningNumbers() {
        try {
            outputView.inputWinningNumber();
            lottoMapper.setWinningNumber(inputView.winningNumbers());
        } catch (Exception e) {
            outputView.exceptionMessage(e.getMessage());
            inputWinningNumbers();
        }
    }

    private void inputBonusNumber() {
        try {
            outputView.inputBonusNumber();
            lottoMapper.setBonusNumber(inputView.bonusNumber());
        } catch (Exception e) {
            outputView.exceptionMessage(e.getMessage());
            inputBonusNumber();
        }
    }

    public void printWinningStatistics() {
        outputView.winningStatistics(lottoMapper.getResult());
    }
}
