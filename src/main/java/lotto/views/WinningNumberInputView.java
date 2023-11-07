package lotto.views;

import lotto.constants.StringConstants;

public class WinningNumberInputView implements View {
    @Override
    public void render() {
        System.out.println(StringConstants.INPUT_WINNING_MESSAGE);
    }
}
