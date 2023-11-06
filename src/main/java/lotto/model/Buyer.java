package lotto.model;

import java.util.ArrayList;

public class Buyer {
    private final int totalAmount ;
    private final ArrayList<Lotto> lottoTickets;

    public Buyer(int purchaseAmount, ArrayList<Lotto> lottoTickets){
        this.totalAmount = purchaseAmount;
        this.lottoTickets = lottoTickets;
    }


}
