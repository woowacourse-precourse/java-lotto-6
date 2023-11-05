package lotto.view.input;

import lotto.domain.lotto.Lotto;
import lotto.message.LottoBuyMessage;
import lotto.util.LottoFactory;
import lotto.validator.LottoGameInputValidator;
import lotto.validator.LottoNumberInputValidator;

import java.util.Arrays;
import java.util.List;

public class LottoGameInputViewView implements InputView {

    private final LottoNumberInputValidator numberValidator;
    private final LottoGameInputValidator gameInfoValidator;

    public LottoGameInputViewView() {
        this.numberValidator = new LottoNumberInputValidator();
        this.gameInfoValidator = new LottoGameInputValidator();
    }

    @Override
    public long requestLottoPurchaseAmount() {
        printRequestLottoPurchaseAmount();
        long amount = gameInfoValidator.parseLong(readLine());
        gameInfoValidator.validatePositiveNumber(amount);
        newLine();
        return amount;
    }

    private void printRequestLottoPurchaseAmount() {
        System.out.println(LottoBuyMessage.PURCHASE_AMOUNT_PROMPT_MESSAGE.getMassage());
    }

    @Override
    public Lotto requestWinningLotto() {
        printRequestWinningLottoNumbers();

        List<Integer> numbers = getNumbers();
        validateWiningLottoNumbers(numbers);
        newLine();

        return LottoFactory.createLotto(numbers);
    }

    private void printRequestWinningLottoNumbers() {
        System.out.println(LottoBuyMessage.WINNING_NUMBERS_PROMPT_MESSAGE.getMassage());
    }

    private List<Integer> getNumbers() {
        return Arrays.stream(readLine().split(","))
                .map(numberValidator::parseInt)
                .toList();
    }

    private void validateWiningLottoNumbers(List<Integer> numbers) {
        numberValidator.validateLottoSize(numbers);
        numberValidator.validateLottoNumberRange(numbers);
    }

    @Override
    public int requestBonusLottoNumber(Lotto winningLotto) {
        printRequestBonusLottoNumber();

        int bonusNumber = numberValidator.parseInt(readLine());
        validateBonusLottoNumber(bonusNumber, winningLotto);
        newLine();

        return bonusNumber;
    }

    private void printRequestBonusLottoNumber() {
        System.out.println(LottoBuyMessage.BONUS_NUMBER_PROMPT_MESSAGE.getMassage());
    }

    private void validateBonusLottoNumber(int bonusNumber, Lotto winningLotto) {
        numberValidator.validateLottoNumberRange(bonusNumber);
        numberValidator.validateBonusNumberMatch(bonusNumber, winningLotto.getNumbers());
    }
}
