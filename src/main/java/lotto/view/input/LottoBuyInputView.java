package lotto.view.input;

import lotto.message.LottoBuyMessage;
import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.List;

public class LottoBuyInputView extends Input{


    //util로 뺴지 않은 이유는 inputView만 사용하기 때문에 lifeCycle이 같아야 된다고 생각한다.
    private final InputValidator inputValidator;
    private final int denomination;

    public LottoBuyInputView(int denomination) {
        //LottoController에서 InputView가 InputValidator를 의존하는지 알 필요가 없다고 생각한다.
        this.inputValidator = new InputValidator();
        this.denomination = denomination;
    }

    public int requestLottoPurchaseAmount() {
        printRequestLottoPurchaseAmount();

        int amount = inputValidator.parseInt(readLine());
        validateLottoAmount(amount, denomination);

        return amount;
    }

    private void printRequestLottoPurchaseAmount() {
        System.out.println(LottoBuyMessage.PURCHASE_AMOUNT_PROMPT_MESSAGE);
    }

    private void validateLottoAmount(int amount, int denomination) {
        inputValidator.validateLottoAmount(amount);
        inputValidator.validateMultipleOfDenomination(amount, denomination);
    }

    //사이즈랑 정렬되서 들어왔는지 확인하기
    public List<Integer> requestWinningLottoNumbers() {
        printRequestWinningLottoNumbers();

        List<Integer> numbers = getNumbers();
        validateWiningLottoNumbers(numbers);

        return numbers;
    }

    private void printRequestWinningLottoNumbers() {
        System.out.println(LottoBuyMessage.WINNING_NUMBERS_PROMPT_MESSAGE);
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

    public int requestBonusLottoNumber() {
        printRequestBonusLottoNumber();

        int bonusNumber = inputValidator.parseInt(readLine());
        validateBonusLottoNumber(bonusNumber);

        return bonusNumber;
    }

    private void printRequestBonusLottoNumber() {
        System.out.println(LottoBuyMessage.BONUS_NUMBER_PROMPT_MESSAGE);
    }

    private void validateBonusLottoNumber(int bonusNumber) {
        inputValidator.validateLottoNumberRange(bonusNumber);
    }

}
