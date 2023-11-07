package lotto.views;

import lotto.constants.StringConstants;
import lotto.io.Input;

public class BonusNumberInputView implements View<Integer> {
    @Override
    public Integer render() {
        System.out.println(StringConstants.INPUT_BONUS_MESSAGE);
        return Input.readLineAsInt();
    }
}
