package lotto.controller;

import static java.lang.String.format;
import static lotto.constant.LottoOutputMessage.*;

import java.util.List;
import lotto.Lotto;
import lotto.domain.LottoGame;
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
        LottoGame lottoGame = initLottoGame(purchaseCount);
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

    private LottoGame initLottoGame(Integer purchaseCount) {
        List<Lotto> lottos = lottoGameService.purchase(purchaseCount);
        outputView.output(
                format(PURCHASE_COUNT.getMessage(), purchaseCount)
        );
        lottos.forEach(lotto -> outputView.output(lotto.toString()));
        return new LottoGame(lottos);
    }
}
