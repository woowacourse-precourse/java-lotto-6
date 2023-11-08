package domain;

import lotto.Lotto;

import java.util.List;

public class LottoPrinter {
    public static void printFormattedLottoNumbers(List<Lotto> lottoNumbers) {
        for (Lotto lotto : lottoNumbers) {
            toString(lotto);
        }
    }

    private static void toString(Lotto lotto) {
        System.out.print("[");
        for (int i = 0; i < lotto.getNumbers().size(); i++) {
            System.out.print(lotto.getNumbers().get(i));
            if (i < lotto.getNumbers().size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}