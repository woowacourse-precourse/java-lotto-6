package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class GamePrint {

    private static final String INPUT_PRICE = "구입금액을 입력해 주세요.";

    public static void inputPrice() {
        System.out.println(INPUT_PRICE);
    }

    public static void numberOfPurchases(int buyLottoNumber) {
        System.out.printf("\n%s개를 구매했습니다.\n", buyLottoNumber);
    }

    public static void lottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.printSortedNumber());
        }
    }
}
