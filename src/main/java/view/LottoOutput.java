package view;

import domain.Lotto;
import java.util.List;

public class LottoOutput {

    private final String LOTTO_COUNT_WORD = "%d개를 구매했습니다.";

    public void lottoOutput(int count, List<Lotto> allLotto) {
        lottoCount(count);
        allRandomLotto(allLotto);
    }

    private void lottoCount(int count) {
        System.out.printf((LOTTO_COUNT_WORD) + "%n", count);
    }

    private void allRandomLotto(List<Lotto> allLotto) {
        for (Lotto lotto : allLotto) {
            System.out.println(lotto.getNumbers());
        }
    }
}
