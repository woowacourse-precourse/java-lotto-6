package lotto.domain;

import static lotto.Util.Validate.validateAmount;
import static lotto.Util.Validate.validateNumber;

public class PlayerBuyLotto {
    private static final int LOTTO_BUY_MIN = 1000;
    private final int buy;

    public PlayerBuyLotto(String buy) {
        int buyNum = validateNumber(buy);
        validateAmount(buyNum);
        this.buy = buyNum;
    }

    public int calcLottoCount() {
        return buy/LOTTO_BUY_MIN;
    }
}
