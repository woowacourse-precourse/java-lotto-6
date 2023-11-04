package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.InputMessage;
import lotto.view.Input;

public class Core {
    public void start() {
        int amount = 0;
        while (true) {
            System.out.println(InputMessage.AMOUNT.getMessage());
            try {
                amount = Input.readAmount(Console.readLine());
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
