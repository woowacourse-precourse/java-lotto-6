package lotto.view.input;

import lotto.domain.lotto.Lotto;
import lotto.message.LottoBuyMessage;
import lotto.util.LottoFactory;
import lotto.validator.LottoNumberInputValidator;

import java.util.Arrays;
import java.util.List;

public class LottoNumberInputView extends Input{

    private final LottoNumberInputValidator validator;

    public LottoNumberInputView() {
        this.validator = new LottoNumberInputValidator();
    }

    public Lotto requestWinningLotto() {
        printRequestWinningLottoNumbers();

        List<Integer> numbers = getNumbers();
        validateWiningLottoNumbers(numbers);
        newLine();

        return LottoFactory.createLotto(numbers);
    }

    private void newLine() {
        System.out.println();
    }

    private void printRequestWinningLottoNumbers() {
        System.out.println(LottoBuyMessage.WINNING_NUMBERS_PROMPT_MESSAGE.getMassage());
    }

    private List<Integer> getNumbers() {
        return Arrays.stream(readLine().split(","))
                .map(validator::parseInt)
                .toList();
    }

    private void validateWiningLottoNumbers(List<Integer> numbers) {
        validator.validateLottoSize(numbers);
        validator.validateLottoNumberRange(numbers);
    }

    public int requestBonusLottoNumber(Lotto winningLotto) {
        printRequestBonusLottoNumber();

        int bonusNumber = validator.parseInt(readLine());
        validateBonusLottoNumber(bonusNumber, winningLotto);
        newLine();

        return bonusNumber;
    }

    private void printRequestBonusLottoNumber() {
        System.out.println(LottoBuyMessage.BONUS_NUMBER_PROMPT_MESSAGE.getMassage());
    }

    private void validateBonusLottoNumber(int bonusNumber, Lotto winningLotto) {
        validator.validateLottoNumberRange(bonusNumber);
        validator.validateBonusNumberMatch(bonusNumber, winningLotto.getNumbers());
    }

}
