package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class GamePrint {

    private static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    private static final String BUY_LOTTO = "\n%s개를 구매했습니다.\n";
    private static final String INPUT_WINNER_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    public static void inputPrice() {
        System.out.println(INPUT_PRICE);
    }

    public static void numberOfPurchases(int buyLottoNumber) {
        System.out.printf(BUY_LOTTO, buyLottoNumber);
    }

    public static void lottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.printSortedNumber());
        }
    }

    public static void winnerNumbersMessage() {
        System.out.println(INPUT_WINNER_NUMBER);
    }

    public static void bonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER);
    }
}
