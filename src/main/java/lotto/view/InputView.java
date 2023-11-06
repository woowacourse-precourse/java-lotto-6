package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.utils.InputParser;

public class InputView {
    private static final String INPUT_LOTTO_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_BONUS = "\n보너스 번호를 입력해 주세요.";

    public static int getPlayerLottoMoney() {
        System.out.println(INPUT_LOTTO_MONEY);
        return InputParser.parseStringToInteger(reader());
    }

    public static List<Integer> getLottoWinnning() {
        System.out.println(INPUT_LOTTO_WINNING);
        return InputParser.parseStringToIntegerList(reader());
    }

    public static int getLottoBonus() {
        System.out.println(INPUT_LOTTO_BONUS);
        return InputParser.parseStringToInteger(reader());
    }

    private static String reader() {
        return Console.readLine().trim();
    }
}
