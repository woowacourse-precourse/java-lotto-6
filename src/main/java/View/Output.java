package View;

import lotto.Lotto;

import java.util.List;

public class Output {
    public static void printCreatedLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for(Lotto lotto: lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

}
