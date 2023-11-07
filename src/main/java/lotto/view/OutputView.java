package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {

    public static void printLottoNumbersByPurchaseAmount(List<Lotto> lottoNumbers) {
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottoNumbers) {
            System.out.println(lotto.getNumbersStringBySortedAsc());
        }
    }
}
