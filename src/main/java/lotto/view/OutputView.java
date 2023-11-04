package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";

    public void displayLottoCount(long lottoCount) {
        System.out.println(lottoCount + LOTTO_PURCHASE_MESSAGE);
    }

    public void displayLottoReturns(List<Lotto> tickets) {
        for (Lotto lotto : tickets) {
            System.out.println(lotto.getNumbers());
        }
    }
}
