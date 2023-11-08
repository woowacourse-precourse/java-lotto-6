package lotto.controller;

import lotto.dto.input.MoneyDto;
import lotto.dto.input.WinningCombinationDto;
import lotto.dto.output.LottosDto;
import lotto.dto.output.PrizeStatisticsDto;
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
        purchaseLottoTickets();
        generatePrizeStatistics();
    }

    private void purchaseLottoTickets() {
        MoneyDto money = inputView.inputMoney();
        LottosDto lottoTickets = lottoService.purchaseLottoTickets(money);
        outputView.printPurchasedLottoTickets(lottoTickets);
    }

    private void generatePrizeStatistics() {
        WinningCombinationDto winningCombination = inputView.inputWinningCombination();
        PrizeStatisticsDto result = lottoService.calculateDrawingResult(winningCombination);
        outputView.printResult(result);
    }
}
