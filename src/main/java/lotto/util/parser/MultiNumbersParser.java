package lotto.util.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.ErrorMessage;

public class MultiNumbersParser extends AbstractParser<List<Integer>> {

    @Override
    public List<Integer> parse(String input) {
        validateIsNotBlank(input);
        return convert(input);
    }

    @Override
    protected List<Integer> convert(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER);
        }
    }
}
