package domain;

import java.util.List;

public class LottoPrinter {
    public static void printFormattedLottoNumbers(List<List<Integer>> lottoNumbers) {
        for (List<Integer> lotto : lottoNumbers) {
            toString(lotto);
        }
    }

    private static void toString(List<Integer> lotto) {
        System.out.print("[");
        for (int i = 0; i < lotto.size(); i++) {
            System.out.print(lotto.get(i));
            if (i < lotto.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}