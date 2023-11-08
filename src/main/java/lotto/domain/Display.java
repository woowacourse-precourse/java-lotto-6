package lotto.domain;

import java.util.List;

public class Display {
    private static final String LOTTO_COUNT_INFOMATION = "개를 구매했습니다.";

    public void lottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + LOTTO_COUNT_INFOMATION);
        for (Lotto lotto : lottos) {
            lotto.sort();
            System.out.println(lotto);
        }
    }
}
