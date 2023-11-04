package lotto.service;

import lotto.constant.NumberConstant;
import lotto.model.IssuedLotto;
import lotto.model.PurchaseAmount;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private int purchaseAmount;
    private List<IssuedLotto> issuedLotto;

    public int inputPurchaseAmount(String input){
        purchaseAmount = PurchaseAmount.validated(input);
        return purchaseAmount;
    }

    public List<IssuedLotto> createIssuedLotto(){
        int issuedLottoCount = purchaseAmount/ NumberConstant.LOTTO_ONE_PRICE;
        issuedLotto = new ArrayList<>();
        for(int i=1; i<issuedLottoCount; i++){
            issuedLotto.add(new IssuedLotto());
        }
        return issuedLotto;
    }

}
