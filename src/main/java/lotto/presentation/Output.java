package lotto.presentation;

import java.util.List;
import lotto.data.Lotto;

public class Output {
    final private String OUTPUT_PURCHASED_LOTTOS = "개를 구매했습니다.";

    public void printPurchasedLottos(List<Lotto> lottos){
        System.out.println(lottos.size() + OUTPUT_PURCHASED_LOTTOS);
        for(Lotto lotto : lottos){
            lotto.print();
        }
    }

}
