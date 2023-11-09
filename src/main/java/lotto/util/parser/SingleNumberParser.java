package lotto.util.parser;

import lotto.constant.ErrorMessage;

public class SingleNumberParser extends AbstractParser<Integer> {

    @Override
    public Integer parse(String input) {
        validateIsNotBlank(input);
        return convert(input);
    }

    @Override
    protected Integer convert(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER);
        }
    }
}
