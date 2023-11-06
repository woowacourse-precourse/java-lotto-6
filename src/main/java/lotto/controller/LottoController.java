package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.util.Message;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView = OutputView.getInstance();
    private final InputView inputView = InputView.getInstance();
    private final LottoService lottoService = LottoService.getInstance();
    private User user;
    private Result result;

    public static LottoController getInstance() {
        return LottoController.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final LottoController INSTANCE = new LottoController();
    }

    public void run() {
        createUser(getPurchase());
        printUserLottoInfo();
        getResultLotto();
    }

    private void createUser(int purchaseNumber) {
        List<Lotto> lottos = lottoService.getLottoList(purchaseNumber);
        user = new User(purchaseNumber, lottos);
    }

    private int getPurchase() {
        outputView.printMessage(Message.GET_PURCHASE_AMOUNT);
        int purchaseAmount = inputView.getPurchaseAmount();

        return lottoService.getPurchaseNumber(purchaseAmount);
    }

    private void printUserLottoInfo() {
        outputView.printPurchaseNotice(user.getPurchaseNumber());
        outputView.printUserLottos(user.getLottos());
    }

    private void getResultLotto() {
        outputView.printMessage(Message.GET_LOTTO_NUMBER);
        String inputNumber = inputView.getLottoResult();
        List<Integer> lottoNumber = lottoService.toList(inputNumber);
        Lotto resultLotto = lottoService.getLotto(lottoNumber);

        outputView.printMessage(Message.GET_LOTTO_BONUS_NUMBER);
        int bonusNumber = inputView.getBonusNumber();
        result = new Result(resultLotto, bonusNumber);
    }
}
