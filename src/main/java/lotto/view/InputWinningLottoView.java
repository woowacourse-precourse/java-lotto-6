package lotto.view;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class InputWinningLottoView extends InputView {
    private static final Pattern PATTERN = Pattern.compile("(\\d{1,2},){5}\\d{1,2}");
    private static final String INPUT_WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";

    public List<Integer> getValue() {
        System.out.println(INPUT_WINNING_LOTTO_MESSAGE);
        String result = inputValue();
        System.out.println();
        return Stream.of(result.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private void validate(String inputValue) {
        if (!PATTERN.matcher(inputValue).matches()) {
            throw new IllegalArgumentException();
        }
    }
}
