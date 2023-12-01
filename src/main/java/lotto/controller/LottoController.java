package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.exception.ExceptionHandler;
import lotto.service.LottoService;
import lotto.service.dto.Result;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final LottoController instance = new LottoController();

    private LottoController() {
    }

    public static LottoController getInstance() {
        return instance;
    }

    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private final LottoService lottoService = LottoService.getInstance();

    public void run() {
        LottoBundle lottoBundle = ExceptionHandler.handle(this::createLottoBundleFromUserInput);
        outputView.printLottoBundle(lottoBundle);

        Lotto winningLotto = ExceptionHandler.handle(this::createWinningLottoFromUserInput);
        BonusNumber bonusNumber = ExceptionHandler.handle(this::createBonusNumberFromUserInput, winningLotto);

        Result result = lottoService.createResult(lottoBundle, winningLotto, bonusNumber);
        outputView.printResult(result);
    }

    private BonusNumber createBonusNumberFromUserInput(final Lotto winningLotto) {
        int number = inputView.readBonusNumber();
        return lottoService.createBonusNumber(number, winningLotto);
    }

    private Lotto createWinningLottoFromUserInput() {
        List<Integer> numbers = inputView.readLottoNumbers();
        return lottoService.createLotto(numbers);
    }

    private LottoBundle createLottoBundleFromUserInput() {
        int purchasePrice = inputView.readPurchasePrice();
        return lottoService.createLottoBundle(purchasePrice);
    }
}
