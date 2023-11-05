package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.message.ExceptionMessage;

public class InputView {
    public int inputAmount(){
        try {
            String input = Console.readLine();

            return Integer.parseInt(input);
        }catch (NumberFormatException e) {
            System.out.println(ExceptionMessage.INVALID_AMOUNT_TYPE.getMessage());
            throw new IllegalArgumentException();
        }
    }


}
