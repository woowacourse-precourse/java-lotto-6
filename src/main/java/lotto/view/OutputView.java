package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {

    private static final String PURCHASE_NUM_INFORMATION_MESSAGE_FORMAT = "%d개를 구매했습니다.";

    public static void printMessage() {
        System.out.println();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLottos(Lottos lottos) {
        List<Lotto> lottoCollection= lottos.getLottoCollection();
        printMessage(String.format(PURCHASE_NUM_INFORMATION_MESSAGE_FORMAT, lottoCollection.size()));
        lottoCollection.forEach(Lotto::printLotto);
        OutputView.printMessage();
    }


}
