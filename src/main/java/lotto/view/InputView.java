package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public static int inputBudget() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 정수여야 합니다.");
        }
    }

    public static String inputAnswer() {
        return Console.readLine();
    }

}
