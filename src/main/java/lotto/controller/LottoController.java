package lotto.controller;

import lotto.dto.input.MoneyDto;
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
        MoneyDto money = getAmountFromUserInput();
        // 실행
        LottosDto lottoTickets = service.drawLottoTicketsWithGivenMoney(money);
        // 출력
        printPurchasedLottoTickets(lottoTickets);

    }

    private void printPurchasedLottoTickets(LottosDto lottoTickets) {
        outputView.printLottoTickets(lottoTickets);
    }

    private MoneyDto getAmountFromUserInput() {
        try {
            return inputView.inputMoney();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return getAmountFromUserInput();
        }
    }
}
