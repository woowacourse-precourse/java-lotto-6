package lotto.controller;

import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTickets;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningTicket;
import lotto.domain.service.LottoService;
import lotto.dto.Result;
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
        PurchaseAmount purchaseAmount = repeat(() -> new PurchaseAmount(inputView.inputPurchaseAmount()));

        LottoTickets lottoTickets = lottoService.purchase(purchaseAmount);
        outputView.printPurchasedLottos(lottoTickets.lottos());

        WinningTicket winningTicket = repeat(this::getWinningTicket);

        Result winningResult = lottoService.getWinningResult(lottoTickets, winningTicket);
        outputView.printWinningResult(winningResult);
    }

    private WinningTicket getWinningTicket() {
        Lotto winningLotto = repeat(() -> new Lotto(inputView.inputWinningNumbers()));
        LottoNumber bonusNumber = repeat(() -> new LottoNumber(inputView.inputBonusNumber()));
        return new WinningTicket(winningLotto, bonusNumber);
    }

    private static <T> T repeat(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeat(supplier);
        }
    }
}
