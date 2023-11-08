package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.order.PurchaseOrder;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.ticket.WinningTicket;
import lotto.dto.Result;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public void run() {
        final PurchaseOrder purchaseOrder = repeat(this::createPurchaseOrder);
        final LottoTickets lottoTickets = lottoService.purchase(purchaseOrder);
        outputView.printPurchasedLottos(lottoTickets.purchasedLottos());

        final WinningTicket winningTicket = repeat(this::createWinningTicket);
        final Result winningResult = lottoService.getWinningResult(lottoTickets, winningTicket);
        outputView.printWinningResult(winningResult);
    }

    private PurchaseOrder createPurchaseOrder() {
        final int amount = inputView.readPurchaseAmount();
        return new PurchaseOrder(amount);
    }

    private WinningTicket createWinningTicket() {
        final Lotto winningLotto = repeat(this::askWinningLotto);
        final LottoNumber bonusNumber = repeat(this::askBonusNumber);
        return new WinningTicket(winningLotto, bonusNumber);
    }

    private Lotto askWinningLotto() {
        final List<Integer> numbers = inputView.readWinningNumbers();
        return new Lotto(numbers);
    }

    private LottoNumber askBonusNumber() {
        final int bonusNumber = inputView.readBonusNumber();
        return LottoNumber.of(bonusNumber);
    }

    private static <T> T repeat(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeat(supplier);
        }
    }
}
