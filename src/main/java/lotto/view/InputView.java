package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private static final String COMMA_SEPARATOR = ",";

    public static String inputPurchaseAmount() {
        return Console.readLine();
    }

    public static List<String> inputWinningNumbers() {
        return List.of(Console.readLine().split(COMMA_SEPARATOR));
    }

    public static String inputBonusNumber() {
        return Console.readLine();
    }
}
