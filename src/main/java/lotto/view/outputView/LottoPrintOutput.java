package lotto.view.outputView;

import lotto.model.lottoGenerator.Lotto;

import java.util.List;

public class LottoPrintOutput {

    public void displayLottos(List<Lotto> lotto) {
        System.out.printf("%d개를 구매했습니다.\n", lotto.size());

        for (Lotto item : lotto) {
            System.out.println(item.getNumbers());
        }
    }
}





