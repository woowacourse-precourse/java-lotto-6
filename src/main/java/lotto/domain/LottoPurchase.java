package lotto.domain;

import java.util.List;

public class LottoPurchase {
    private final int LottoPurchaseCnt;

    public LottoPurchase(int LottoPurchaseCnt){
        validate(LottoPurchaseCnt);
        this.LottoPurchaseCnt = LottoPurchaseCnt;
    }

    private void validate(int LottoPurchaseCnt) {
        return;
    }

}
