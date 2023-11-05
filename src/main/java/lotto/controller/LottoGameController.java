package lotto.controller;

import static java.lang.String.format;
import static lotto.constant.LottoOutputMessage.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
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
        Integer purchaseCount = initPurchaseAmount();
        LottoStore lottoStore = initLottoStore(purchaseCount);
        initWinningNumber();
    }

    private WinningNumber initWinningNumber() {
        List<String> winningNumberInput = requestWinningNumber();
        return new WinningNumber(winningNumberInput);
    }

    private List<String> requestWinningNumber() {
        outputView.output(WINNING_NUMBER.getMessage());
        return inputView.requestWinningNumber();
    }

    private Integer initPurchaseAmount() {
        while (true) {
            try {
                String purchaseAmountInput = requestPurchaseAmount();
                return lottoGameService.validatePurchaseAmount(purchaseAmountInput);
            } catch (IllegalArgumentException exception) {
                outputView.output(exception.getMessage());
            }
        }
    }

    private String requestPurchaseAmount() {
        outputView.output(PURCHASE_AMOUNT.getMessage());
        return inputView.requestPurchaseAmount();
    }

    private LottoStore initLottoStore(Integer purchaseCount) {
        List<Lotto> lottos = lottoGameService.purchase(purchaseCount);
        outputView.output(
                format(PURCHASE_COUNT.getMessage(), purchaseCount)
        );
        lottos.forEach(lotto -> outputView.output(lotto.toString()));
        return new LottoStore(lottos);
    }
}
