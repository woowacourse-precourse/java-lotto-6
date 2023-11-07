package lotto.Service;

import lotto.constant.GameConstants;

public class PurchaseService {

    public int calculateLottoCount(int purchasePrice){
        return purchasePrice/ GameConstants.LOTTO_PRICE;
    }
}
