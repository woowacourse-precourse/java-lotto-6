package lotto.views;

import lotto.constants.StringConstants;

public class LottoInputView implements View {
    @Override
    public void render() {
        System.out.println(StringConstants.INPUT_BUY_PRICE);
    }
}
