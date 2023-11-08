package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoPurchase;
import lotto.domain.WinningLotto;
import lotto.enums.ConstantsMessage;
import lotto.services.LottoNumberGenerator;
import lotto.utils.LottoValidator;
import lotto.utils.Parser;
import lotto.utils.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoValidator validator;
    private final LottoFactory lottoFactory;

    public InputController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = new LottoValidator();
        this.lottoFactory = new LottoFactory(new LottoNumberGenerator(new RandomNumberGenerator()));
    }

    private String inputMoney() {
        outputView.printMessage(ConstantsMessage.INPUT_PURCHASE_AMOUNT);
        return inputView.inputPurchaseAmount();
    }

    private String inputWinningNumbers() {
        outputView.printMessage(ConstantsMessage.INPUT_WINNING_NUMBERS);
        return inputView.inputWinningNumbers();
    }

    private String inputBonusNumber() {
        outputView.printMessage(ConstantsMessage.INPUT_BONUS_NUMBER);
        return inputView.inputBonusNumber();
    }

    public LottoPurchase calculateLottoCount() {
        try {
            String moneyInput = inputMoney();
            return new LottoPurchase(moneyInput);
        } catch (IllegalArgumentException e) {
            outputView.print(e.getMessage());
            return calculateLottoCount();
        }
    }

    public List<Lotto> purchaseLottos(int purchaseCount) {
        try {
            return lottoFactory.purchaseLottos(purchaseCount);
        } catch (IllegalArgumentException e) {
            outputView.print(e.getMessage());
            return purchaseLottos(purchaseCount);
        }
    }

    public Lotto getWinningNumbers() {
        try {
            String winningNumbersInput = inputWinningNumbers();
            Parser parser = new Parser(validator);

            List<Integer> winningNumbers = parser.parseNumbers(winningNumbersInput);
            return new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            outputView.print(e.getMessage());
            return getWinningNumbers();
        }
    }

    private int getBonusNumber(Lotto winningLotto) {
        try {
            String bonunsInput = inputBonusNumber();
            int bonusNumber = validator.validateNonNumeric(bonunsInput);
            validator.validateNumberRange(bonusNumber);
            validator.validateDuplicateBounus(winningLotto, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            outputView.print(e.getMessage());
            return getBonusNumber(winningLotto);
        }
    }

    public WinningLotto generateWinningLotto() {
        try {
            Lotto winningLotto = getWinningNumbers();
            int bonus = getBonusNumber(winningLotto);
            return new WinningLotto(winningLotto, bonus);
        } catch (IllegalArgumentException e) {
            outputView.print(e.getMessage());
            return generateWinningLotto();
        }
    }

}
