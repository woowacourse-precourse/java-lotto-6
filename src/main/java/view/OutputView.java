package view;

import Model.Lotto;

import java.util.List;

public class OutputView {

    public static void printMyLotto(List<Lotto> lottoNumbers) {
        int length = lottoNumbers.size();
        System.out.println(length + "개를 구매했습니다.");
        for (Lotto lotto : lottoNumbers) {
            printNumbers(lotto);
        }
    }

    public static void printNumbers(Lotto lotto) {
        int length = lotto.getSize();
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print(lotto.getItem(i));
            if (i != length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
