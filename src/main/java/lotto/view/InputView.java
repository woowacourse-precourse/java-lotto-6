package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorMsg;

public class InputView {

    public int parseInputFromUserInteger() {
        while (true) {
            try {
                int price = Integer.parseInt(Console.readLine());
                return price;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMsg.ERROR_INPUT_NOT_NUMBER.getMsg());
            }
        }
    }

    public String commonInput() {
        String userInput = Console.readLine();
        return userInput;
    }
}
