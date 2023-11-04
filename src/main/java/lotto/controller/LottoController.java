package lotto.controller;

import static lotto.view.constant.Message.NOTICE_TOTAL_PROFIT;
import static lotto.view.constant.Message.NOTICE_PURCHASE_QUANTITY;

import java.util.Objects;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.domain.LottoResults;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumber;
import lotto.exception.LottoException;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoTickets lottoTickets;
    private WinningNumber winningNumber;
    private LottoResults lottoResults;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = Objects.requireNonNull(inputView);
        this.outputView = Objects.requireNonNull(outputView);
    }

    public void run() {
            getLottoTickets();
            printLottoNumbers();

            getWinningNumber();
            getBonusNumber();

            printLottoResult();
            printTotalProfit();
    }

    private void getLottoTickets() {
        try {
            String input = inputView.requestPurchaseMoney();
            lottoTickets = LottoTickets.purchase(input);
            printLottoTicketQuantity();
        } catch (LottoException e) {
            outputView.printErrorMessage(e);
            getLottoTickets();
        }
    }

    private void getWinningNumber() {
        try {
            String input = inputView.requestWinningNumber();
            winningNumber = WinningNumber.create(input);
        } catch (LottoException e) {
            outputView.printErrorMessage(e);
            getWinningNumber();
        }
    }

    private void getBonusNumber() {
        try {
            String input = inputView.requestBonusNumber();
            winningNumber.createBonusNumber(input);
        } catch (LottoException e) {
            outputView.printErrorMessage(e);
            getBonusNumber();
        }
    }

    private void printLottoTicketQuantity() {
        try {
            outputView.printDynamicMessage(
                    NOTICE_PURCHASE_QUANTITY,
                    lottoTickets.getLottoTicketQuantity()
            );
        } catch (LottoException e) {
            outputView.printErrorMessage(e);
            getLottoTickets();
        }
    }

    private void printLottoNumbers() {
        outputView.printIterableMessage(lottoTickets.getLottoNumbers());
    }

    private void printLottoResult() {
        lottoResults = winningNumber.compareWithLottos(lottoTickets);
        outputView.printResult(lottoResults.toString());
    }

    private void printTotalProfit() {
        outputView.printDynamicMessage(NOTICE_TOTAL_PROFIT, lottoResults.getTotalProfit());
    }
}
