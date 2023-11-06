package lotto.view;

import java.util.List;
import lotto.utils.Reader;

public class InputView {
    private static final String INPUT_LOTTO_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_BONUS = "\n보너스 번호를 입력해 주세요.";

    public static int getPlayerLottoMoney() {
        System.out.println(INPUT_LOTTO_MONEY);
        return Reader.parseNumberInteger();
    }

    public static List<Integer> getLottoWinnning() {
        System.out.println(INPUT_LOTTO_WINNING);
        return Reader.parseNumbersInteger();
    }

    public static int getLottoBonus() {
        System.out.println(INPUT_LOTTO_BONUS);
        return Reader.parseNumberInteger();
    }
}
