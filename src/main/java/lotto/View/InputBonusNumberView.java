package lotto.View;

import lotto.Util.Rule;

public class InputBonusNumberView extends InputView {

    public Integer getValue() {
        System.out.println(Rule.INPUTBONUSNUM_MESSAGE);
        String result = inputValue();
        System.out.println();
        validate(result);
        return Integer.parseInt(result);
    }
    private void validate(String inputValue) {
        valedateFormat(inputValue);
    }
    private void valedateFormat(String inputValue) {
        if(!Rule.NUMBER_PATTERN.matcher(inputValue).matches()) {
            throw new IllegalArgumentException(Rule.NOTNUMBER_PATTERN);
        }
    }
}
