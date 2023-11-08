package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.WinLotto;
import lotto.service.LottoService;
import lotto.util.Message;
import lotto.util.Validator;
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
        int purchaseAmount;

        while (true) {
            outputView.printMessage(Message.GET_PURCHASE_AMOUNT);
            String input = inputView.getPurchaseAmount();

            try {
                Validator.validateLottoPurchaseAmount(input);
                purchaseAmount = Integer.parseInt(input);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }

        return lottoService.getNumberOfLottoPapers(purchaseAmount);
    }

    private void printUserLottoInfo() {
        outputView.printPurchaseNotice(user.getNumberOfLottoPapers());
        outputView.printUserLottos(user.getLottos());
    }

    private void getWinLotto() {
        Lotto winLottoNumber = getWinLottoNumber();
        int winLottoBonusNumber = getWinLottoBonusNumber(winLottoNumber.getLottoNumbers());

        this.winLotto = new WinLotto(winLottoNumber, winLottoBonusNumber);
    }

    private Lotto getWinLottoNumber() {
        List<Integer> lottoNumber;

        while (true) {
            outputView.printMessage(Message.GET_LOTTO_NUMBER);
            String inputNumber = inputView.getLottoResult();

            try {
                Validator.validateWinLotto(inputNumber);
                lottoNumber = lottoService.numbersToList(inputNumber);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }

        return lottoService.getLotto(lottoNumber);
    }

    private int getWinLottoBonusNumber(List<Integer> numbers) {
        int bonus;

        while (true) {
            outputView.printMessage(Message.GET_LOTTO_BONUS_NUMBER);
            String input = inputView.getBonusNumber();
            try {
                Validator.validateWinBonus(input, numbers);
                bonus = Integer.parseInt(input);
                break;
            } catch (IllegalArgumentException e) {

            }
        }
        
        return bonus;
    }
}
