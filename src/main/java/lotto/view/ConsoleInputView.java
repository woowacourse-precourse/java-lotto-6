package lotto.view;

import static lotto.utils.InputException.NOT_DIGIT_FORM;
import static lotto.utils.InputException.NOT_LOTTO_NUMBERS_FORM;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleInputView {
    private static final String COMMA = ",";
    private static final String LOTTO_NUMBERS_REGEX = "^\\d+(,\\d+)*$";

    public int readPurchaseAmount() {
        try {
            String amount = readLineWithoutGap();
            return convertToInt(amount);
        } catch (NumberFormatException e) {
            NOT_DIGIT_FORM.throwException();
            return readPurchaseAmount();
        }
    }

    public List<Integer> readWinningLotto() {
        String winningNumbers = readLineWithoutGap();
        validateLottoNumbersFormat(winningNumbers);
        return convertToList(winningNumbers);
    }

    private String readLineWithoutGap() {
        return Console.readLine().trim();
    }

    private int convertToInt(String input) {
        return Integer.parseInt(input);
    }

    private void validateLottoNumbersFormat(String lottoNumbers) {
        if (isNotValidLottoNumbersFormat(lottoNumbers)) {
            NOT_LOTTO_NUMBERS_FORM.throwException();
        }
    }

    private boolean isNotValidLottoNumbersFormat(String lottoNumbers) {
        return !lottoNumbers.matches(LOTTO_NUMBERS_REGEX);
    }

    private List<Integer> convertToList(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(COMMA))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
