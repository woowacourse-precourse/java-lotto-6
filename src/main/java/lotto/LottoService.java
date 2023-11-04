package lotto;

import static lotto.Constant.BUY_UNIT;

public class LottoService {

    public long getLottoAmount(long buyCash){
        return buyCash/BUY_UNIT;
    }

    public double getTotalProfitRate(long totalProfit,long buyCash){
        return Math.round((double)totalProfit/buyCash*1000.0)/10.0;
    }
}
