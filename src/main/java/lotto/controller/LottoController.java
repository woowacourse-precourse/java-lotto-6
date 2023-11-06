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
        // 입력
        MoneyDto money = inputView.inputMoney();
        // 실행
        LottosDto lottoTickets = lottoService.purchaseLottoTickets(money);
        // 출력
        printPurchasedLottoTickets(lottoTickets);

        // 입력
        WinningCombinationDto winningNumbers = inputView.inputWinningNumbers();
        // 실행
        DrawingResultDto result = lottoService.calculateDrawingResult(winningNumbers);
        // 출력
        outputView.printResult(result);
    }

    private void printPurchasedLottoTickets(LottosDto lottoTickets) {
        outputView.printPurchasedLottoTickets(lottoTickets);
    }

}
