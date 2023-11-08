package lotto.view;

import java.util.List;
import java.util.StringJoiner;
import lotto.Lotto;

public class OutputView {

    public static void printPurchasedLottoCount(Integer lottoCount) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLotto(List<Integer> lottoNumbers) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");

        for (Integer num : lottoNumbers) {
            joiner.add(num.toString());
        }
        String result = joiner.toString();
        System.out.println(result);
    }
}
