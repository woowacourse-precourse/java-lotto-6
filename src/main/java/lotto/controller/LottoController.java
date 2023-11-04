package lotto.controller;

import lotto.domain.dto.LottosDto;
import lotto.domain.dto.PurchaseAmountDto;
import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoController(InputView inputView, OutputView outputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public void start() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        PurchaseAmountDto purchaseAmountDto = inputView.inputPurchaseAmount();
        LottosDto lottosDto = lottoMachine.issuedLottos(purchaseAmountDto);
        outputView.printPurchaseQuantityLottos(purchaseAmountDto);
        outputView.printIssuedPurchaseResult(lottosDto);
    }


}