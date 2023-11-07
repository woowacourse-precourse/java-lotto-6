package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.User;

public class OutputLottoNumbersView {

    public static void printLottos(Lottos lottos) {
        System.out.print("[");
        for(Lotto lotto : lottos.getLottos()){
            System.out.print(lotto);
        }
        System.out.println("]");
    }

}
