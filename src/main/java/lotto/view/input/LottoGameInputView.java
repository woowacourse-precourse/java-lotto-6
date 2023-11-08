package lotto.view.input;

import lotto.domain.lotto.Cash;
import lotto.domain.lotto.Lotto;
import lotto.util.LottoFactory;
import lotto.view.input.validator.LottoNumberInputValidator;

import java.util.Arrays;
import java.util.List;

import static lotto.constants.LottoRule.STANDARD;
import static lotto.message.ErrorMessage.INVALID_LOTTO_AMOUNT;
import static lotto.view.input.message.LottoBuyInputMessage.PURCHASE_AMOUNT_PROMPT_MESSAGE;
import static lotto.view.input.message.LottoBuyInputMessage.WINNING_NUMBERS_PROMPT_MESSAGE;
import static lotto.view.input.message.LottoBuyInputMessage.BONUS_NUMBER_PROMPT_MESSAGE;

public class LottoGameInputView implements ConsoleInput {

    private final LottoNumberInputValidator validator;

    public LottoGameInputView() {
        this.validator = new LottoNumberInputValidator();
    }

    @Override
    public Cash requestLottoCash() {
        printRequestLottoPurchaseAmount();

        long requestCash = validator.parseLong(readLine());
        Cash cash = validateCashRequest(requestCash);
        newLine();

        return cash;
    }

    private Cash validateCashRequest(long requestCash) {
        Cash cash = new Cash(requestCash);
        validateLottoPurchase(cash);

        return cash;
    }

    private void validateLottoPurchase(Cash cash) {
        if (cash.isPurchaseLottoPossible(STANDARD.getLottoPrice())) {
            throw new IllegalArgumentException(INVALID_LOTTO_AMOUNT.getMessage());
        }
    }

    private void printRequestLottoPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT_MESSAGE.getMassage());
    }

    @Override
    public Lotto requestWinningLotto() {
        printRequestWinningLottoNumbers();

        List<Integer> numbers = getNumbers();
        newLine();

        return LottoFactory.createLotto(numbers);
    }

    private void printRequestWinningLottoNumbers() {
        System.out.println(WINNING_NUMBERS_PROMPT_MESSAGE.getMassage());
    }

    private List<Integer> getNumbers() {
        return Arrays.stream(readLine().split(","))
                .map(validator::parseInt)
                .toList();
    }

    @Override
    public int requestBonusLottoNumber(Lotto winningLotto) {
        printRequestBonusLottoNumber();

        int bonusNumber = validator.parseInt(readLine());
        validateBonusLottoNumber(bonusNumber, winningLotto);
        newLine();

        return bonusNumber;
    }

    private void printRequestBonusLottoNumber() {
        System.out.println(BONUS_NUMBER_PROMPT_MESSAGE.getMassage());
    }

    private void validateBonusLottoNumber(int bonusNumber, Lotto winningLotto) {
        validator.validateLottoNumberRange(bonusNumber);
        validator.validateBonusNumberMatch(bonusNumber, winningLotto.getNumbers());
    }
}
