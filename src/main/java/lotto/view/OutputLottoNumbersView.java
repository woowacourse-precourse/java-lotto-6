package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.User;

public class OutputLottoNumbersView {

    public static void printLottos(Lottos lottos) {
        for(Lotto lotto : lottos.getLottos()){
            printLotto(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void printLotto(List<Integer> lotto) {
        System.out.println(Arrays.deepToString(lotto.toArray()));
    }

}
