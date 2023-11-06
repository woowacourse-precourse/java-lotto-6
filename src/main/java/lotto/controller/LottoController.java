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
    private final LottoService service;

    public LottoController(InputView inputView, OutputView outputView, LottoService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void run() {
        // 입력
        MoneyDto money = inputView.inputMoney();
        // 실행
        LottosDto lottoTickets = service.purchaseLottoTickets(money);
        // 출력
        printPurchasedLottoTickets(lottoTickets);

        // 입력
        WinningCombinationDto winningNumbers = inputView.inputWinningNumbers();
        //BonusNumberDto bonusNumber = getBonusNumberFromUserInput();
        // 실행
        //DrawingResultDto result = service.findPrize(winningNumbers, bonusNumber);
        DrawingResultDto result = service.findPrize(winningNumbers);
        // 출력
        outputView.printResult(result);
    }

    private void printPurchasedLottoTickets(LottosDto lottoTickets) {
        outputView.printPurchasedLottoTickets(lottoTickets);
    }

}
