package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";

    private Input() {
    }

    public static int money() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return Converter.stringToInt(Console.readLine());
    }

    public static List<Integer> winLottoNumbers() {
        System.out.println();
        System.out.println(INPUT_WIN_NUMBERS_MESSAGE);
        return Converter.stringToListInteger(Console.readLine());
    }

    public static int bonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_MESSAGE);
        return Converter.stringToInt(Console.readLine());
    }
}
