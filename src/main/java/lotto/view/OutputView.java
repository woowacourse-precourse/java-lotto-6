package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    public static final String PRINT_AMOUNT = "개를 구매했습니다.";

    public void printAmount(int amount) {
        System.out.println("\n"+amount/1000+PRINT_AMOUNT);
    }

    public void printLottos(List<Lotto> lottos) {
        for(Lotto lotto: lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
