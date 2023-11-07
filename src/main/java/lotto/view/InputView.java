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

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return StringHandler.separatedWith(input, STRING_DELIMITER);
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return StringHandler.stringToInt(input);
    }

}
