package lotto.domain;

import lotto.view.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private  static List<Lotto> lottoTickets;



    public static void buyLottoTickets(long purchaseAmount) throws IllegalArgumentException{
        if(purchaseAmount%1000!=0){
             throw new IllegalArgumentException(ExceptionMessage.inputPurchaseAmountError.getErrorMessage());
        }

        LottoTickets.lottoTickets = putBuyLottoTickets(purchaseAmount);
    }

    private static List<Lotto> putBuyLottoTickets(long purchaseAmount){
        List<Lotto> buyLottoTickets = new ArrayList<>();
        int purchasesNum = (int) (purchaseAmount/1000);
        while(purchasesNum!=0){
            buyLottoTickets.add(Lotto.getRandomNumLotto());
            purchasesNum --;
        }
        return buyLottoTickets;
    }


}
