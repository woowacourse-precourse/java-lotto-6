package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.util.StringHandler;

public class OutputView {
    private static final String DELIMITER = ", ";

    public void printLottos(List<Lotto> lottos, int lottosCount) {
        String lottosMessage = String.format("%d개를 구매했습니다.",lottosCount);
        System.out.println(lottosMessage);
        for(Lotto lotto : lottos) {
            System.out.println(StringHandler.joinBy(lotto.getNumbers(), DELIMITER));
        }
    }
}
