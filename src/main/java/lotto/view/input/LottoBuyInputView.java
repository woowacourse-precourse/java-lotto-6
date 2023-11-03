package lotto.view.input;

import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.List;

public class LottoBuyInputView extends Input{

    private static final String PURCHASE_AMOUNT_PROMPT_MESSAGE = "구입할 Lotto 금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String REGEX = ",";

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
        inputValidator.validateLottoAmount(amount);
        inputValidator.validateMultipleOfDenomination(amount, denomination);

        return amount;
    }

    private void printRequestLottoPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT_MESSAGE);
    }

    //사이즈랑 정렬되서 들어왔는지 확인하기
    public List<Integer> requestWinningLottoNumbers() {
        printRequestWinningLottoNumbers();
        List<Integer> numbers = getNumbers();
        inputValidator.checkForDuplicateLottoNumbers(numbers);
        inputValidator.validateLottoSize(numbers);
        inputValidator.validateSortedAscending(numbers);

        return numbers;
    }

    private List<Integer> getNumbers() {
        return Arrays.stream(readLine().split(REGEX))
                .map(inputValidator::parseInt)
                .toList();
    }

    private void printRequestWinningLottoNumbers() {
        System.out.println(WINNING_NUMBERS_PROMPT_MESSAGE);
    }

}
