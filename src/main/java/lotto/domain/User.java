package lotto.domain;

import java.util.List;
import java.util.ArrayList;
import lotto.util.RandomChoice;;

public class User {
    List<Lotto> lotto = new ArrayList<Lotto>();
    private int ticketAmount;
    private int purchaseAmount;

    public User(int ticketAmount, int purchaseAmount) {
        this.ticketAmount = ticketAmount;
        this.purchaseAmount = purchaseAmount;
    }

    public void setLotto() {
        for (int i = 0; i < getTicketAmount(); i++) {
            Lotto ticket = new Lotto(RandomChoice.createLottoNumbers());
            lotto.add(ticket);
        }
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public int getPurchaseAmount(){
        return purchaseAmount;
    }

    public List<Lotto> getLottoList() {
        return lotto;
    }

}
