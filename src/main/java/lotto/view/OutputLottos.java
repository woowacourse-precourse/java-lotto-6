package lotto.view;

import lotto.dto.Lotto;
import lotto.dto.Lottos;

public class OutputLottos {
    public static void printLottos(Lottos lottos){
        for (Lotto l : lottos.getLottos()) {
            System.out.println(l);
        }
    }

}
