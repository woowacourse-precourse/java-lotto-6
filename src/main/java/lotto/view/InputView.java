package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public static String inputPurchaseAmount() {
        return Console.readLine();
    }

    public static List<String> inputWinningNumbers() {
        return List.of(Console.readLine().split(","));
    }

    public static String inputBonusNumber() {
        return Console.readLine();
    }
}
