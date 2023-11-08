package lotto.controller;

import java.lang.reflect.Member;
import java.util.List;
import lotto.domain.Customer;
import lotto.domain.LottoResult;
import lotto.domain.PurchasedLotto;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        lottoService = LottoService.startGame();
    }

    public void run() {
        Customer customer = inputView.getCustomer();
        PurchasedLotto purchased
                = lottoService.createLotto(customer.getLottoCount());
        outputView.printPurchasedLotto(purchased);
        WinningLotto winningLotto = inputView.getWinningLotto();
        List<LottoResult> lottoResultList = lottoService.getLottoResultList(purchased, winningLotto);
        outputView.printResult(customer, lottoResultList);
    }


}
