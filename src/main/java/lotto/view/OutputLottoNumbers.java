package lotto.view;

import java.util.List;

public class OutputLottoNumbers {
    public OutputLottoNumbers(List<Integer> lotto) {
    }

    public static List<Integer> print_Lotto(List<Integer> lotto) {
        System.out.print("[");
        for (int i = 0; i < lotto.size(); i++) {
            if (i != lotto.size() - 1)
                System.out.print(lotto.get(i) + ", ");
            else {
                System.out.println(lotto.get(i) + "]");
            }
        }
        return lotto;
    }
}
