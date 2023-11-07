package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.StringHandler;

public class InputView {
    private static final String STRING_DELIMITER = ",";
    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        return StringHandler.stringToInt(input);
    }
}
