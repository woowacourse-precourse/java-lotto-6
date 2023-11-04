package lotto;

import java.util.List;

public class Output {
    public static void message(String message) {
        System.out.println(message);
    }

    public static void issuedLotto(int lottoCount, List<Lotto> lottos) {
        final String purchaseMessage = "개를 구매했습니다.";
        message(Integer.toString(lottoCount).concat(purchaseMessage));

        for (Lotto lotto : lottos) {
            lotto.toString();
        }
    }

}
