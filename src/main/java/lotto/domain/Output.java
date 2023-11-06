package lotto.domain;

import java.util.List;

public class Output {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos){
            System.out.println(lotto);
        }
    }
}
