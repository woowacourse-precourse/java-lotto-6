package lotto.view;

import static lotto.message.InputErrorMessage.INVALID_INPUT_FORMAT;
import static lotto.message.InputErrorMessage.INVALID_INPUT_LOTTO_NUMBERS_COUNT;
import static lotto.message.InputErrorMessage.INVALID_INPUT_LOTTO_RANGE;
import static lotto.message.InputErrorMessage.INVALID_INPUT_MAXIMUM;
import static lotto.message.InputErrorMessage.INVALID_INPUT_NEGATIVE;
import static lotto.message.InputErrorMessage.INVALID_INPUT_UNIT;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";

    private static final String INPUT_LOTTO_NUMBER_SPLITTER = ",";

    private static final int LOTTO_NUMBER_MIN_VALUE = 1;
    private static final int LOTTO_NUMBER_MAX_VALUE = 45;

    private static final int LOTTO_NUMBERS_SIZE = 6;

    public static final String LOTTO_NUMBER_FORMAT = "숫자";

    int requestLottoPurchaseAmount() {
        System.out.println(PURCHASE_MESSAGE);
        String inputValue = Console.readLine().trim();
        validateNumber(inputValue);
        int lottoPurchaseAmount = Integer.parseInt(inputValue);
        validateLottoPurchaseAmount(lottoPurchaseAmount);
        return lottoPurchaseAmount;
    }

    public TreeSet<Integer> requestLottoNumber() {
        System.out.println(LOTTO_NUMBERS_MESSAGE);
        String inputLottoNumbers = Console.readLine().trim();
        validateLottoNumbers(inputLottoNumbers);
        return convertLottoNumbersToTreeSet(inputLottoNumbers);
    }

    private static void validateNumber(String inputValue) {
        String regex = "^\\d+$";

        if (!Pattern.matches(regex, inputValue)) {
            throw new NumberFormatException(String.format(INVALID_INPUT_FORMAT, LOTTO_NUMBER_FORMAT));
        }
    }

    private static void validateLottoPurchaseAmount(int lottoPurchaseAmount) {
        if (lottoPurchaseAmount >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException(INVALID_INPUT_MAXIMUM);
        }

        int reminder = lottoPurchaseAmount % 1000;
        if (reminder > 0) {
            throw new IllegalArgumentException(INVALID_INPUT_UNIT);
        }
    }

    private void validateLottoNumbers(String inputLottoNumbers) {
        String[] lottoNumbers = inputLottoNumbers.split(INPUT_LOTTO_NUMBER_SPLITTER);
        Set<Integer> numbers = new HashSet<>();
        for (String lottoNumber : lottoNumbers) {
            validateNumber(lottoNumber);

            int number = Integer.parseInt(lottoNumber);
            validateLottoNumberRange(number);
            numbers.add(number);
        }
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_INPUT_LOTTO_NUMBERS_COUNT);
        }
    }

    private void validateLottoNumberRange(int number) {
        if (
            LOTTO_NUMBER_MIN_VALUE > number ||
            LOTTO_NUMBER_MAX_VALUE < number
        ) {
            throw new IllegalArgumentException(INVALID_INPUT_LOTTO_RANGE);
        }
    }

    private TreeSet<Integer> convertLottoNumbersToTreeSet(String inputLottoNumbers) {
        String[] lottoNumbers = inputLottoNumbers.split(INPUT_LOTTO_NUMBER_SPLITTER);
        return Stream.of(lottoNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
