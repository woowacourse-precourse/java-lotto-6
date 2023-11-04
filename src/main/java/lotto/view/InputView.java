package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.enumerate.Message;

public class InputView {
    public String inputAmount() {
        System.out.println(Message.PLEASE_INPUT_AMOUNT);
        return readLine();
    }
    public String inputWinningNumber() {

    }
    public String inputBonusNumber() {

    }
}
