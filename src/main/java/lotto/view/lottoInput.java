package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.view.ConstantsMessage.ASK_BUY_PRICE;

public class lottoInput {
    public String askPrice() {
        System.out.println(ASK_BUY_PRICE.getMessage());
        String input = Console.readLine();
        return input;

    }
}
