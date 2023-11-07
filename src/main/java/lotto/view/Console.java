package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Console {

    private static final Pattern REGEX = Pattern.compile("^[0-9]*$");
    private static final String DELIMITER = ",";

    private final Input input;
    private final Output output;

    public Console(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public List<Integer> readWinningNumbers() {
        output.println("당첨 번호를 입력해 주세요.");
        String value = input.read();
        validateNull(value);
        validateType(value);

        return Arrays.stream(value.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    private void validateNull(String value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateType(String value) {
        Arrays.stream(value.split(DELIMITER))
                .filter(input -> !isNumeric(input))
                .findAny()
                .ifPresent(input -> {
                    throw new IllegalArgumentException();
                });
    }

    private boolean isNumeric(String value) {
        return REGEX.matcher(value).matches();
    }

}
