package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.WinLotto;
import lotto.service.LottoService;
import lotto.util.Message;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView = OutputView.getInstance();
    private final InputView inputView = InputView.getInstance();
    private final LottoService lottoService = LottoService.getInstance();
    private User user;
    private WinLotto winLotto;

    public static LottoController getInstance() {
        return LottoController.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final LottoController INSTANCE = new LottoController();
    }

    public void run() {
        createUser(getPurchaseAmount());
        printUserLottoInfo();
        getWinLotto();
    }

    private void createUser(int numberOfLottoPapers) {
        List<Lotto> lottos = lottoService.createLottos(numberOfLottoPapers);
        user = new User(numberOfLottoPapers, lottos);
    }

    private int getPurchaseAmount() {
        outputView.printMessage(Message.GET_PURCHASE_AMOUNT);
        int purchaseAmount = inputView.getPurchaseAmount();

        return lottoService.getNumberOfLottoPapers(purchaseAmount);
    }

    private void printUserLottoInfo() {
        outputView.printPurchaseNotice(user.getNumberOfLottoPapers());
        outputView.printUserLottos(user.getLottos());
    }

    private void getWinLotto() {
        outputView.printMessage(Message.GET_LOTTO_NUMBER);
        String inputNumber = inputView.getLottoResult();
        List<Integer> lottoNumber = lottoService.numbersToList(inputNumber);
        Lotto winLotto = lottoService.getLotto(lottoNumber);

        outputView.printMessage(Message.GET_LOTTO_BONUS_NUMBER);
        int bonusNumber = inputView.getBonusNumber();
        this.winLotto = new WinLotto(winLotto, bonusNumber);
    }
}
