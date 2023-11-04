package lotto.controller;

import static lotto.view.constant.Message.NOTICE_TOTAL_PROFIT;
import static lotto.view.constant.Message.NOTICE_PURCHASE_QUANTITY;

import java.util.Objects;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.domain.LottoResults;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumber;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = Objects.requireNonNull(inputView);
        this.outputView = Objects.requireNonNull(outputView);
    }

    public void run() {
        LottoTickets lottoTickets = getLottoTickets();
        printLottoTicketQuantity(lottoTickets);
        printLottoNumbers(lottoTickets);

        WinningNumber winningNumber = getWinningNumber();
        getBonusNumber(winningNumber);

        LottoResults results = winningNumber.compareWithLottos(lottoTickets);
        printLottoResult(results);
        printTotalProfit(results);
    }

    private LottoTickets getLottoTickets() {
        String input = inputView.requestPurchaseMoney();
        return LottoTickets.purchase(input);
    }

    private WinningNumber getWinningNumber() {
        String input = inputView.requestWinningNumber();
        return WinningNumber.create(input);
    }

    private void getBonusNumber(WinningNumber winningNumber) {
        String input = inputView.requestBonusNumber();
        winningNumber.createBonusNumber(input);
    }

    private void printLottoTicketQuantity(LottoTickets lottoTickets) {
        outputView.printDynamicMessage(
                NOTICE_PURCHASE_QUANTITY,
                lottoTickets.getLottoTicketQuantity()
        );
    }

    private void printLottoNumbers(LottoTickets lottoTickets) {
        outputView.printIterableMessage(lottoTickets.getLottoNumbers());
    }

    private void printLottoResult(LottoResults results) {
        outputView.printResult(results.toString());
    }

    private void printTotalProfit(LottoResults results) {
        outputView.printDynamicMessage(NOTICE_TOTAL_PROFIT, results.getTotalProfit());
    }
}
