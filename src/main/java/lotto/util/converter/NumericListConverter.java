package lotto.util.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumericListConverter implements Converter<String, List<Integer>> {
    @Override
    public List<Integer> convert(String target) {
        List<String> inputs = Arrays.stream(target.split(",")).toList();

        return inputs.stream().map(this::parseInt).collect(Collectors.toList());
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
