package lotto.views;

import lotto.constants.StringConstants;

public class BonusNumberInputView implements View {
    @Override
    public void render() {
        System.out.println(StringConstants.INPUT_BONUS_MESSAGE);
    }
}
