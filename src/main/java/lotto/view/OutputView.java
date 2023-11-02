package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public static void printLottos(int money, List<Lotto> lottos) {
        int lottoQuantity = money / 1000;
        System.out.println(lottoQuantity + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
    
}
