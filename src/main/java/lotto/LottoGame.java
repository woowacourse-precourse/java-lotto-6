package lotto;

import static lotto.Constant.BUY_UNIT;

public class LottoGame {

    public long getLottoAmount(long buyCash){
        return buyCash/BUY_UNIT;
    }
}
