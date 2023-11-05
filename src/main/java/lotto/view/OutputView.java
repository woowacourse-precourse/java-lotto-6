package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRamdomNumbers;

public class OutputView {

    public void printIssuedLottoNumbersInAscendingOrder(List<Lotto> ramdomNumbersList) {
        System.out.println(ramdomNumbersList.size() + OutputMessage.BOUGHT_LOTTO.getMessage());
        for (Lotto lotto : ramdomNumbersList) {
            System.out.println(lotto.toString());
        }
    }
}
