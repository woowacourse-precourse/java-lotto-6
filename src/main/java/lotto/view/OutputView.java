package lotto.view;

import java.util.List;
import lotto.constants.SystemMessage;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {

    public void printInputPurchaseAmount() {
        System.out.println(SystemMessage.INPUT_PURCHASE_AMOUNT.getMessage());
    }

    public void printLottos(Lottos lottos) {
        System.out.println();
        printNumberOfLotto(lottos.getLottos().size());
        printLottoNumber(lottos.getLottos());
    }

    private void printNumberOfLotto(int numberOfLotto) {
        System.out.println(numberOfLotto + "개를 구매했습니다.");
    }

    private void printLottoNumber(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        for(Lotto lotto : lottos) {
            sb.append(lotto).append("\n");
        }
        System.out.println(sb.toString());
    }

}
