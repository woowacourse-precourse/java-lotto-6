package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constants.InputMessage.*;

public final class InputView {

    private InputView() {}

    public static String purchasePrice() {
        System.out.println(PURCHASE_PRICE);
        return Console.readLine();
    }

    public static String lottoNumber() {
        System.out.println(LOTTO_NUMBER);
        return Console.readLine();
    }

    public static String bonusNumber() {
        System.out.println(BONUS_NUMBER);
        return Console.readLine();
    }
}
