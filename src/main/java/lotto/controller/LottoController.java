package lotto.controller;

import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTickets;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.service.LottoService;
import lotto.dto.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        PurchaseAmount purchaseAmount = exceptionHandleAndRetry(this::getPurchaseAmount);
        LottoTickets lottoTickets = lottoService.purchase(purchaseAmount);
        outputView.printPurchasedLottos(lottoTickets.lottos());

        WinningLotto winningLotto = exceptionHandleAndRetry(this::getWinningLotto);
        WinningResult winningResult = lottoService.getWinningResult(lottoTickets, winningLotto);
        outputView.printWinningResult(winningResult);
    }

    private PurchaseAmount getPurchaseAmount() {
        return new PurchaseAmount(inputView.inputPurchaseAmount());
    }

    private WinningLotto getWinningLotto() {
        Lotto lotto = exceptionHandleAndRetry(this::getLotto);
        LottoNumber bonusNumber = exceptionHandleAndRetry(this::getLottoNumber);
        return new WinningLotto(lotto, bonusNumber);
    }

    private Lotto getLotto() {
        return new Lotto(inputView.inputWinningNumbers());
    }

    private LottoNumber getLottoNumber() {
        return new LottoNumber(inputView.inputBonusNumber());
    }

    private <T> T exceptionHandleAndRetry(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return exceptionHandleAndRetry(supplier);
        }
    }
}
