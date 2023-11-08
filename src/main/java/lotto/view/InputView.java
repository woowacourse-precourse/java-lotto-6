package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputPurchasePrice() {
        return Console.readLine().replace(" ", "");
    }

    public static String inputWinNumber() {
        return Console.readLine().replace(" ", "");
    }

    public static String inputBonusNumber() {
        return Console.readLine().replace(" ", "");
    }


}
