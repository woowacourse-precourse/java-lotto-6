package lotto.view.input;

import lotto.domain.lotto.Lotto;
import lotto.view.input.message.LottoBuyInputMessage;
import lotto.util.LottoFactory;
import lotto.view.input.validator.LottoGameInputValidator;
import lotto.view.input.validator.LottoNumberInputValidator;

import java.util.Arrays;
import java.util.List;

public class LottoGameInputView implements ConsoleInput {

    private final LottoNumberInputValidator numberValidator;
    private final LottoGameInputValidator gameInfoValidator;

    public LottoGameInputView() {
        this.numberValidator = new LottoNumberInputValidator();
        this.gameInfoValidator = new LottoGameInputValidator();
    }

    @Override
    public long requestLottoPurchaseAmount() {
        printRequestLottoPurchaseAmount();

        long amount = gameInfoValidator.parseLong(readLine());
        validateAmount(amount);

        newLine();
        return amount;
    }

    private void validateAmount(long amount) {
        gameInfoValidator.validatePositiveNumber(amount);
        gameInfoValidator.validateLottoPurchase(amount);
    }

    private void printRequestLottoPurchaseAmount() {
        System.out.println(LottoBuyInputMessage.PURCHASE_AMOUNT_PROMPT_MESSAGE.getMassage());
    }

    @Override
    public Lotto requestWinningLotto() {
        printRequestWinningLottoNumbers();

        List<Integer> numbers = getNumbers();
        newLine();

        return LottoFactory.createLotto(numbers);
    }

    private void printRequestWinningLottoNumbers() {
        System.out.println(LottoBuyInputMessage.WINNING_NUMBERS_PROMPT_MESSAGE.getMassage());
    }

    private List<Integer> getNumbers() {
        return Arrays.stream(readLine().split(","))
                .map(numberValidator::parseInt)
                .toList();
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
        System.out.println(LottoBuyInputMessage.BONUS_NUMBER_PROMPT_MESSAGE.getMassage());
    }

    private void validateBonusLottoNumber(int bonusNumber, Lotto winningLotto) {
        numberValidator.validateLottoNumberRange(bonusNumber);
        numberValidator.validateBonusNumberMatch(bonusNumber, winningLotto.getNumbers());
    }
}
