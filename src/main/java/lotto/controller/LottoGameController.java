package lotto.controller;

import static java.lang.String.format;
import static lotto.constant.LottoOutputMessage.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.PurchaseCount;
import lotto.domain.WinningNumber;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final OutputView outputView;
    private final InputView inputView;
    private final LottoGameService lottoGameService;

    public LottoGameController() {
        outputView = new OutputView();
        inputView = new InputView();
        lottoGameService = new LottoGameService();
    }

    public void run() {
        PurchaseCount purchaseCount = initPurchaseAmount();
        LottoStore lottoStore = initLottoStore(purchaseCount);
        WinningNumber winningNumber = initWinningNumber();
        initBonusNumber();
    }

    private void initBonusNumber() {
        outputView.output(BONUS_NUMBER.getMessage());
    }

    private WinningNumber initWinningNumber() {
        while (true) {
            try {
                List<String> winningNumberInput = requestWinningNumber();
                return new WinningNumber(winningNumberInput);
            } catch (IllegalArgumentException exception) {
                outputView.output(exception.getMessage());
            }
        }
    }

    private List<String> requestWinningNumber() {
        outputView.output(WINNING_NUMBER.getMessage());
        return inputView.requestWinningNumber();
    }

    private PurchaseCount initPurchaseAmount() {
        while (true) {
            try {
                String purchaseAmountInput = requestPurchaseAmount();
                return new PurchaseCount(purchaseAmountInput);
            } catch (IllegalArgumentException exception) {
                outputView.output(exception.getMessage());
            }
        }
    }

    private String requestPurchaseAmount() {
        outputView.output(PURCHASE_AMOUNT.getMessage());
        return inputView.requestPurchaseAmount();
    }

    private LottoStore initLottoStore(PurchaseCount purchaseCount) {
        List<Lotto> lottos = lottoGameService.purchase(purchaseCount);
        outputView.output(
                format(PURCHASE_COUNT.getMessage(), lottos.size())
        );
        lottos.forEach(lotto -> outputView.output(lotto.toString()));
        return new LottoStore(lottos);
    }
}
