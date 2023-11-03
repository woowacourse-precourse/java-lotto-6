package lotto;

public class LottoGame {

    public long getLottoAmount(long buyCash){
        return buyCash/Constant.BUY_UNIT;
    }
}
