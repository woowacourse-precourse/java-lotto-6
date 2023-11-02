package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ErrorMessage;

public abstract class Input {

    public static String readLine(){
        return Console.readLine();
    }

    protected int parseInt(String requestNumber) {
        int number;
        try {
            number = Integer.parseInt(requestNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_FORMAT.getMessage());
        }
        return number;
    }

}
