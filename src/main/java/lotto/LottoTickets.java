package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    List<Lotto> lottoTickets = new ArrayList<>();

    private LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets crateLottoTickets(long purchaseAmount) throws IllegalArgumentException{
        if(purchaseAmount%1000!=0){
             throw new IllegalArgumentException("ERROR");
        }
        List<Lotto> buyLottoTickets = new ArrayList<>();
        int purchasesNum = (int) (purchaseAmount/1000);
        while(purchasesNum!=0){
            buyLottoTickets.add(Lotto.getRandomNumLotto());
            purchasesNum --;
        }
        LottoTickets lottoTickets = new LottoTickets(buyLottoTickets);
        return lottoTickets;
    }


}
