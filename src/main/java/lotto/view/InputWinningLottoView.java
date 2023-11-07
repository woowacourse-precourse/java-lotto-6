package lotto.view;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import lotto.exception.DuplicateWinningNumberException;
import lotto.exception.InvalidLottoInputFormatException;

public class InputWinningLottoView extends InputView {
    private static final Pattern PATTERN = Pattern.compile("(\\d{1,2},){5}\\d{1,2}");
    private static final String INPUT_WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final int LOTTO_SIZE = 6;

    public List<Integer> getValue() {
        System.out.println(INPUT_WINNING_LOTTO_MESSAGE);
        String result = inputValue();
        System.out.println();
        validate(result);
        return Stream.of(result.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private void validate(String inputValue) {
        validateFormat(inputValue);
        validateDuplicate(inputValue);
    }

    private void validateFormat(String inputValue) {
        if (!PATTERN.matcher(inputValue).matches()) {
            throw new InvalidLottoInputFormatException();
        }
    }

    private void validateDuplicate(String inputValue) {
        List<Integer> numbers = Stream.of(inputValue.split(","))
                .map(Integer::parseInt)
                .toList();
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LOTTO_SIZE) {
            throw new DuplicateWinningNumberException();
        }
    }
}
