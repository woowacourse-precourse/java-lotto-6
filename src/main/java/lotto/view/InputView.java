package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.utils.InputParser;

public class InputView {
    private static final String INPUT_PLAYER_LOTTO_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_LOTTO = "\n보너스 번호를 입력해 주세요.";

    public static int getPlayerLottoMoney() {
        System.out.println(INPUT_PLAYER_LOTTO_MONEY);
        return InputParser.parseStringToInteger(reader());
    }

    public static List<Integer> getWinningLotto() {
        System.out.println(INPUT_WINNING_LOTTO);
        return InputParser.parseStringToIntegerList(reader());
    }

    public static int getBonusLotto() {
        System.out.println(INPUT_BONUS_LOTTO);
        return InputParser.parseStringToInteger(reader());
    }

    private static String reader() {
        return Console.readLine().trim();
    }
}
