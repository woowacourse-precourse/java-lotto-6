package lotto.View.OutputView;

import java.util.Arrays;
import lotto.Model.Lotto;
import lotto.Model.Lottos;

public class PrintLottos {

    public static void printLottos(Lottos lottos) {
        getPrintLottos(lottos);
    }

    private static void getPrintLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            Integer[] tempArray = lotto.getNumbers().toArray(new Integer[0]);
            Arrays.sort(tempArray);
            System.out.println(Arrays.toString(tempArray));
        }
        System.out.println();
    }

}
