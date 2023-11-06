package lotto.view;

import static lotto.util.content.DisplayMessage.SET_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static Integer purchaseAmount() {
        System.out.println(SET_PURCHASE_AMOUNT.getContent());
        return Integer.parseInt(Console.readLine());
    }

}
