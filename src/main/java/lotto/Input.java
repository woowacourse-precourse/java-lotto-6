package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String costInput() {
        System.out.println(Message.INPUT_COST.getMessage());
        return Console.readLine();
    }

    public String targetInput() {
        System.out.println(Message.INPUT_TARGET.getMessage());
        return Console.readLine();
    }

    public String bonusInput() {
        System.out.println(Message.INPUT_BONUS.getMessage());
        return Console.readLine();
    }
}
