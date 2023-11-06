package lotto;

import java.util.List;

public class OutputIssuance {
    public void print(int purchase_count, List<List<Integer>> purchase_lottos) {
        System.out.printf("%d개를 구매했습니다.\n", purchase_count);
        for (List<Integer> lotto : purchase_lottos) {
            System.out.println(lotto);
        }
    }
}
