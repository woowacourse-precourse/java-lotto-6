package lotto.view.input;

import java.util.Arrays;
import java.util.List;

public class IntegerInputs {
    private static final String SPLIT_DELIMETER = ",";
    private static final int SPLIT_LIMIT = -1;

    private final List<IntegerInput> values;

    public IntegerInputs(String input) {
        this.values = Arrays.stream(input.split(SPLIT_DELIMETER, SPLIT_LIMIT))
                .map(IntegerInput::new)
                .toList();
    }

    public List<Integer> values() {
        return values.stream()
                .map(IntegerInput::value)
                .toList();
    }
}
