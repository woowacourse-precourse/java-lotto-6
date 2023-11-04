package lotto.view.input;

import lotto.domain.lotto.Lotto;
import lotto.message.LottoBuyMessage;
import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.List;

public class LottoNumberInputView extends Input{

    private final InputValidator inputValidator;

    public LottoNumberInputView() {
        this.inputValidator = new InputValidator();
    }

    public List<Integer> requestWinningLottoNumbers() {
        printRequestWinningLottoNumbers();

        List<Integer> numbers = getNumbers();
        validateWiningLottoNumbers(numbers);
        System.out.println();

        return numbers;
    }

    private void printRequestWinningLottoNumbers() {
        System.out.println(LottoBuyMessage.WINNING_NUMBERS_PROMPT_MESSAGE.getMassage());
    }

    private List<Integer> getNumbers() {
        return Arrays.stream(readLine().split(LottoBuyMessage.REGEX.getMassage()))
                .map(inputValidator::parseInt)
                .toList();
    }

    private void validateWiningLottoNumbers(List<Integer> numbers) {
        inputValidator.validateLottoSize(numbers);
        inputValidator.validateLottoNumberRange(numbers);
    }

    public int requestBonusLottoNumber(Lotto winningLotto) {
        printRequestBonusLottoNumber();

        int bonusNumber = inputValidator.parseInt(readLine());
        validateBonusLottoNumber(bonusNumber, winningLotto);
        System.out.println();

        return bonusNumber;
    }

    private void printRequestBonusLottoNumber() {
        System.out.println(LottoBuyMessage.BONUS_NUMBER_PROMPT_MESSAGE.getMassage());
    }

    private void validateBonusLottoNumber(int bonusNumber, Lotto winningLotto) {
        inputValidator.validateLottoNumberRange(bonusNumber);
        inputValidator.validateBonusNumberMatch(bonusNumber, winningLotto.getNumbers());
    }

}
