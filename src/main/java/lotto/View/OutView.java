package lotto.View;

import java.util.List;
import lotto.Lotto;

public class OutView {
    static final String SUCCESFULLY_PURCHASE_LOTTO = "개를 구매했습니다.";

    public static void printPurchasedLottos(List<String> lottoNumbers, int lottoQuantity) {
        System.out.println("\n" + lottoQuantity + SUCCESFULLY_PURCHASE_LOTTO);
        for (String lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }
}
