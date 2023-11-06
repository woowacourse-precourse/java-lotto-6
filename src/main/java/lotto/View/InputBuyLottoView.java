package lotto.View;

import lotto.Util.Rule;

import java.util.regex.Pattern;

public class InputBuyLottoView extends InputView {

    public Integer getValue() {
        System.out.println(Rule.INPUTBUY_MESSAGE);
        String result = inputValue();
        System.out.println();
        validate(result);
        return Integer.parseInt(result);
    }

    private void validate(String inputValue) {
        validateFormat(inputValue);
    }

    private void validateFormat(String inputVlaue) {
        if(!Rule.NUMBER_PATTERN.matcher(inputVlaue).matches()) {
            throw new IllegalArgumentException(Rule.NOTNUMBER_PATTERN);
        }
    }
}
