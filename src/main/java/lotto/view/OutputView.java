package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {
    public void printBuyLotto(int lottoAmount) {
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }

    public void printTotalLotto(List<Lotto> lottos) {
        lottos.forEach(Lotto::printLotto);
    }
}
