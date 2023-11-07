package lotto.domain;

import lotto.view.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    List<Lotto> lottoTickets;

    private LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public static LottoTickets createBuyLottoTickets(long purchaseAmount) throws IllegalArgumentException{
        if(purchaseAmount%1000!=0){
             throw new IllegalArgumentException(ExceptionMessage.inputPurchaseAmountError.getErrorMessage());
        }

        LottoTickets lottoTickets = new LottoTickets(buyLottoTickets(purchaseAmount));
        return lottoTickets;
    }

    private static List<Lotto> buyLottoTickets(long purchaseAmount){
        List<Lotto> buyLottoTickets = new ArrayList<>();
        int purchasesNum = (int) (purchaseAmount/1000);
        while(purchasesNum!=0){
            buyLottoTickets.add(Lotto.getRandomNumLotto());
            purchasesNum --;
        }
        return buyLottoTickets;
    }


}
