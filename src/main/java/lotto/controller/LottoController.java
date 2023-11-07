package lotto.controller;

import static lotto.view.constant.Message.NOTICE_TOTAL_PROFIT;
import static lotto.view.constant.Message.NOTICE_PURCHASE_QUANTITY;

import java.util.Objects;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.domain.Lottos;
import lotto.domain.LottoResults;
import lotto.domain.WinningNumber;
import lotto.exception.LottoException;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private Lottos lottos;
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
        while (true) {
            try {
                String input = inputView.requestPurchaseMoney();
                lottos = Lottos.purchase(input);
                printLottoQuantity();
                return;
            } catch (LottoException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private void getWinningNumber() {
        while (true) {
            try {
                String input = inputView.requestWinningNumber();
                winningNumber = WinningNumber.create(input);
                return;
            } catch (LottoException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private void getBonusNumber() {
        while (true) {
            try {
                String input = inputView.requestBonusNumber();
                winningNumber.createBonusNumber(input);
                return;
            } catch (LottoException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private void printLottoQuantity() {
        while (true) {
            try {
                outputView.printDynamicMessage(
                        NOTICE_PURCHASE_QUANTITY,
                        lottos.getLottoQuantity()
                );
                return;
            } catch (LottoException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private void printLottoNumbers() {
        outputView.printIterableMessage(lottos.getLottoNumbers());
    }

    private void printLottoResult() {
        lottoResults = winningNumber.compareWithLottos(lottos);
        outputView.printResult(lottoResults.toString());
    }

    private void printTotalProfit() {
        outputView.printDynamicMessage(NOTICE_TOTAL_PROFIT, lottoResults.getTotalProfit());
    }
}
