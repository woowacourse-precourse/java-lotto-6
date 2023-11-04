package lotto.view;

import static lotto.util.message.Guide.PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String purchase() {
        System.out.println(PURCHASE_AMOUNT);
        return Console.readLine();
    }
}
