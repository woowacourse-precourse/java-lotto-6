package lotto.controller;

import lotto.dto.input.MoneyDto;
import lotto.dto.input.WinningCombinationDto;
import lotto.dto.output.DrawingResultDto;
import lotto.dto.output.LottosDto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        purchaseLottoTicketsAndDisplay();
        calculateAndDisplayDrawingResult();
    }

    private void purchaseLottoTicketsAndDisplay() {
        MoneyDto money = inputView.inputMoney();
        LottosDto lottoTickets = lottoService.purchaseLottoTickets(money);
        outputView.printPurchasedLottoTickets(lottoTickets);
    }

    private void calculateAndDisplayDrawingResult() {
        WinningCombinationDto winningCombination = inputView.inputWinningCombination();
        DrawingResultDto result = lottoService.calculateDrawingResult(winningCombination);
        outputView.printResult(result);
    }
}
