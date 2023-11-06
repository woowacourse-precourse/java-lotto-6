package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public void printLottos(List<Lotto> bundle) {
        System.out.printf("%d" + InformationMessage.PURCHASE.getMessage(), bundle.size());
        for (Lotto lotto : bundle) {
            System.out.println(lotto);
        }
    }
}
