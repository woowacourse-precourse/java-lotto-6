package lotto.View;

import lotto.Domain.Lotto;
import lotto.Domain.Lottos;

public class outputLottoList {
    public static void printLottoList(Lottos lottos){
        lottos.getLottos().forEach(System.out::println);
        System.out.println();
    }
}
