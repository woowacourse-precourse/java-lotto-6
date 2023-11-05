package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputPurchaseAmount(){
        return Console.readLine().trim();
    }

    public static String inputWinnerNumbers(){
        return Console.readLine().trim();
    }

    public static String inputBonusNumbers(){
        return Console.readLine().trim();
    }
}
