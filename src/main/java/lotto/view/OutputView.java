package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {

    public static void displayUserLottos(List<Lotto> userLottos) {
        String purchaseHeader = String.format("%d개를 구매했습니다.", userLottos.size());
        System.out.println(purchaseHeader);
        userLottos.forEach(userLotto -> {
            System.out.println(userLotto.getDisplayFormat());
        });
    }
}
