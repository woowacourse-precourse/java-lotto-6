package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputView.InputBonusNotPositiveIntegerException;
import lotto.exception.InputView.InputLottoNotPositiveIntegerException;
import lotto.exception.InputView.InputLottoSeparateRegexException;
import lotto.exception.InputView.InputPriceNotPositiveIntegerException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final String SPECIAL_CHARACTER_REGEX = ".*[!@#\\$%^&*()_+\\[\\]{};':\"\\\\<>./?`~\\-=|\\s].*";
    private static final String SEPARATOR_REGEX = ",";
    private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";

    public int inputPrice() {
        String line = Console.readLine();

        validateInputPricePositiveInteger(line);

        return Integer.parseInt(line);
    }

    public List<Integer> inputLotto() {
        String line = Console.readLine();

        validateInputLottoSeparateRegex(line);
        validateInputLotto(line);

        String[] split = line.split(SEPARATOR_REGEX);
        return Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int inputBonus() {
        String line = Console.readLine();

        validateInputBonus(line);

        return Integer.parseInt(line);
    }

    private void validateInputPricePositiveInteger(String line) {
        if (!line.matches(POSITIVE_INTEGER_REGEX)) {
            throw new InputPriceNotPositiveIntegerException();
        }
    }

    private void validateInputLotto(String line) {
        String[] split = line.split(SEPARATOR_REGEX);
        for (String s : split) {
            if (!s.matches(POSITIVE_INTEGER_REGEX)) {
                throw new InputLottoNotPositiveIntegerException(); //
            }
        }
    }

    private void validateInputLottoSeparateRegex(String line) {
        Pattern pattern = Pattern.compile(SPECIAL_CHARACTER_REGEX);
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            throw new InputLottoSeparateRegexException();
        }
    }

    private void validateInputBonus(String line) {
        if (!line.matches(POSITIVE_INTEGER_REGEX)) {
            throw new InputBonusNotPositiveIntegerException();
        }
    }
}
