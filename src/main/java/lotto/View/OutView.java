package lotto.View;

import java.util.List;

public class OutView {
    static final String SUCCESFULLY_PURCHASE_LOTTO = "개를 구매했습니다.";

    public static void printPurchasedLottos(List<String> lottoNumbers) {
        System.out.println("\n" + lottoNumbers.size() + SUCCESFULLY_PURCHASE_LOTTO);
        for (String lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }
}
