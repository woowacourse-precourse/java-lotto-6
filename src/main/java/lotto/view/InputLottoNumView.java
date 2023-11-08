package lotto.view;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputLottoNumView extends InputView {
    private static final Pattern PATTERN = Pattern.compile("(\\d+,)+\\d+");
    private static final String INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호의 형식을 맞추어 주세요.";
    public List<Integer> getValue() {
        System.out.println(INPUT_MESSAGE);
        String userInput = inputValue();
        System.out.println();
        validate(userInput);

        return Stream.of(userInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validate(String userInput) throws IllegalArgumentException {
        if(!PATTERN.matcher(userInput).matches()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
