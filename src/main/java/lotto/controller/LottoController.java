package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView = OutputView.getInstance();
    private final InputView inputView = InputView.getInstance();
    private final LottoService lottoService = LottoService.getInstance();
    private User user;

    public static LottoController getInstance() {
        return LottoController.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final LottoController INSTANCE = new LottoController();
    }

    public void run() {
        createUser();

    }

    private void createUser() {
        int purchaseNumber = getPurchase();
        List<Lotto> lottoList = lottoService.getLottoList(purchaseNumber);
        user = new User(purchaseNumber, lottoList);
    }

    private int getPurchase() {
        int purchaseAmount = inputView.getPurchaseAmount();

        return lottoService.getPurchaseNumber(purchaseAmount);
    }
}
