package lotto.views;

import java.util.List;
import lotto.constants.StringConstants;
import lotto.io.Input;

public class WinningNumberInputView implements View<List<Integer>> {
    @Override
    public List<Integer> render() {
        System.out.println(StringConstants.INPUT_WINNING_MESSAGE);
        return Input.readLineAsIntegerList(",");
    }
}
