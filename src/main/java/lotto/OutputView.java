package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {

    public static void printPurchaseCount(int purchaseCount) {
        System.out.println();
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<LottoNumber> lottoNumbers = lotto.getNumbers();
            List<Integer> numbers = new ArrayList<>();
            for (LottoNumber lottoNumber : lottoNumbers) {
                numbers.add(lottoNumber.getNumber());
            }
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public static void printError(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
