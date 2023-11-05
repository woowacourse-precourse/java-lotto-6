package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Counter {
    public int generateLottoCount(int userMoney) {
        int lottoCount = userMoney / 1000;
        return lottoCount;
    }

}
