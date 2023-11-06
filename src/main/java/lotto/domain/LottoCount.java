package lotto.domain;

import static lotto.enums.Constants.*;

public class LottoCount {

    private int value;

    public LottoCount(int purchaseMoney){
        this.value = convertLottoCount(purchaseMoney);
    }

    public int getValue(){
        return value;
    }

    private int convertLottoCount(int purchaseMoney){
        return purchaseMoney / ONE_LOTTO_TICKET_PRICE.getValue();
    }
}
