package output;

import java.util.List;

public class LottoPrinter {
    public static void printLottos(List<List<Integer>> lottos) {
        for(List<Integer> lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }
}
