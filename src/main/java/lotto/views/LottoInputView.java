package lotto.views;

import lotto.constants.StringConstants;
import lotto.io.Input;

public class LottoInputView implements View<Integer> {
    @Override
    public Integer render() {
        System.out.println(StringConstants.INPUT_BUY_PRICE);
        return Input.readLineAsInt();
    }
}
