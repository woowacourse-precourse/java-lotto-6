package lotto.view.console;

import static lotto.exception.InputException.NOT_DIGIT_FORM;
import static lotto.exception.InputException.NOT_LOTTO_NUMBERS_FORM;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.view.InputView;

public class ConsoleInputView implements InputView {
    private static final String COMMA = ",";
    private static final String LOTTO_NUMBERS_REGEX = "^[\\d| ]+(,[\\d| ]+)*$";

    public int readIntegerInput() {
        try {
            String amount = readLineWithoutGap();
            return convertToInt(amount);
        } catch (NumberFormatException e) {
            NOT_DIGIT_FORM.throwException();
            return readIntegerInput();
        }
    }

    public List<Integer> readWinningLotto() {
        String winningNumbers = readLineWithoutGap();
        validateLottoNumbersFormat(winningNumbers);
        return convertToList(winningNumbers);
    }

    public void close() {
        Console.close();
    }

    private String readLineWithoutGap() {
        return Console.readLine().trim();
    }

    private int convertToInt(final String input) {
        return Integer.parseInt(input);
    }

    private void validateLottoNumbersFormat(final String lottoNumbers) {
        if (isNotValidLottoNumbersFormat(lottoNumbers)) {
            NOT_LOTTO_NUMBERS_FORM.throwException();
        }
    }

    private boolean isNotValidLottoNumbersFormat(final String lottoNumbers) {
        return !lottoNumbers.matches(LOTTO_NUMBERS_REGEX);
    }

    private List<Integer> convertToList(final String winningNumbers) {
        return Arrays.stream(winningNumbers.split(COMMA))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
