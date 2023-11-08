package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.Message;

public class WinningNumbersInputView implements InputView {
    @Override
    public String inputWinningNumbers() {
        System.out.println();
        System.out.println(Message.INPUT_WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }
}
