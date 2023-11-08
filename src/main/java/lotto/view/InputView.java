package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;

import lotto.domain.message.ErrorMessage;
import lotto.domain.message.InputViewMessage;
import lotto.validator.LottoNumbersValidator;

public class InputView {
    public List<Integer> inputLottoNumbers() {
        System.out.println(InputViewMessage.INPUT_WINNING_NUMBER_NOTICE.getValue());
        List<String> inputNumbers = Arrays.stream(readLine().split(InputViewMessage.INPUT_DELIMITER.getValue()))
                .map(String::trim)
                .toList();
        inputNumbers.forEach(InputView::validateNumber);
        return LottoNumbersValidator.validate(convertToNumbers(inputNumbers));
    }

    private static List<String> readLineAndSplitWith(final String delimiter) {
        return Arrays.stream(readLine().split(delimiter))
                .map(String::trim)
                .toList();
    }

    private static List<Integer> convertToNumbers(final List<String> inputNumbers) {
        return inputNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private static void validateNumber(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw ErrorMessage.INVALID_NUMBER_FORMAT.createException();
        }
    }
}
