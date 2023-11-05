package lotto.input;

import static lotto.exception.ExceptionMessage.WRONG_LOTTO_NUMBER_INPUT;
import static lotto.exception.ExceptionMessage.WRONG_LOTTO_NUMBER_SIZE;
import static lotto.validator.LottoNumberValidator.LOTTO_NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.validator.LottoNumberValidator;

class LottoNumberInputManager {
    private static final Pattern numberOnly = Pattern.compile("\\d+");

    private LottoNumberInputManager() {
    }

    static List<Integer> fromConsole() {
        String userInput = Console.readLine();
        return fromString(userInput);
    }

    static List<Integer> fromString(String input) {
        List<String> parsedInput = parsedCommaSeperatedInput(input);
        return convertToLottoNumber(parsedInput);
    }

    private static List<String> parsedCommaSeperatedInput(String input) {
        validateCommaSeperatedInput(input);
        var parsedInputs = Arrays.stream(input.split(",")).toList();
        parsedInputs.forEach(LottoNumberInputManager::validateOnlyNumber);
        validateParsedInputCount(parsedInputs);
        return parsedInputs;
    }

    private static void validateCommaSeperatedInput(String input) {
        int inputLength = input.length();
        if (input.charAt(0) == ',' || input.charAt(inputLength - 1) == ',') {
            throw new IllegalArgumentException(WRONG_LOTTO_NUMBER_INPUT);
        }
    }

    private static void validateOnlyNumber(String input) {
        Matcher matcher = numberOnly.matcher(input);
        if (matcher.matches()) {
            return;
        }
        throw new IllegalArgumentException(WRONG_LOTTO_NUMBER_INPUT);
    }

    private static void validateParsedInputCount(List<String> parsedInput) {
        if (parsedInput.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(WRONG_LOTTO_NUMBER_INPUT);
        }
    }

    private static List<Integer> convertToLottoNumber(List<String> parsedInput) {
        List<Integer> lottoNumbers;
        try {
            lottoNumbers = parsedInput.stream().map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_LOTTO_NUMBER_SIZE);
        }
        validateLottoNumberSize(lottoNumbers);
        validateDuplicateLottoNumber(lottoNumbers);
        return lottoNumbers;
    }

    private static void validateLottoNumberSize(List<Integer> numbers) {
        numbers.forEach(number -> LottoNumberValidator.validateNumberIsLottoNumber(number, WRONG_LOTTO_NUMBER_SIZE));
    }

    private static void validateDuplicateLottoNumber(List<Integer> lottoNumbers) {
        LottoNumberValidator.validateDuplicateLottoNumber(lottoNumbers);
    }
}
