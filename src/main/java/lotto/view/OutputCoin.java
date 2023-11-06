package lotto.view;

import lotto.domain.Coin;
import lotto.domain.Lotto;

import java.util.List;

public class OutputCoin {
    private static final String SOLD_MESSAGE = "개를 구매했습니다.";

    public void printLottoKind(int lottoCount) {
        System.out.println(lottoCount + SOLD_MESSAGE);
    }
}
