package lotto.controller;

import lotto.model.LottoList;
import lotto.model.LottoManager;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoManager lottoManager;
    private final LottoList lottoList;
    private static final int LOTTO_PRICE = 1000;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoManager = new LottoManager();
        this.lottoList = new LottoList();
    }

    public void startLottoGame() {
        outputView.askPurchaseAmount();
        int purchaseAmount = inputView.getPurchaseAmountFromUser();
        validatePurchaseAmount(purchaseAmount);
    }

    // 구입 금액은 1000원으로 나누어떨어져야 한다.
    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1000원 단위로 입력 받아야합니다.");
        }
    }


}
