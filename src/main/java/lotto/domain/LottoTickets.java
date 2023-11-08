package lotto.domain;

import lotto.view.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private   List<Lotto> lottoTickets;

    private LottoTickets() {
    }

    private static class LottoTicketsHolder{
        private static final LottoTickets lottoTickets = new LottoTickets();
    }

    public static LottoTickets getInstance(){
        return LottoTicketsHolder.lottoTickets;
    }

    public void buyLottoTickets(long purchaseAmount) throws IllegalArgumentException{
        if(purchaseAmount%1000!=0){
             throw new IllegalArgumentException(ExceptionMessage.inputPurchaseAmountError.getErrorMessage());
        }

        lottoTickets = putBuyLottoTickets(purchaseAmount);
    }



    public  List<Lotto> getBuyLottoTickets(){
        return lottoTickets;
    }

    private  List<Lotto> putBuyLottoTickets(long purchaseAmount){
        List<Lotto> buyLottoTickets = new ArrayList<>();
        int purchasesNum = (int) (purchaseAmount/1000);
        while(purchasesNum!=0){
            buyLottoTickets.add(Lotto.getRandomNumLotto());
            purchasesNum --;
        }
        return buyLottoTickets;
    }


}
