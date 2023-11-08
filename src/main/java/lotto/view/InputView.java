package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.LottoMsg;
import lotto.exception.ErrorMsg;

public class InputView {

    public int parseInputFromUserInteger() {
        System.out.println(LottoMsg.LOTTO_BUY_PRICE.getMsg());
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
