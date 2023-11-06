package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Buyer {
    private final int totalAmount ;
    private final List<Lotto> lottoTickets;

    public Buyer(int purchaseAmount, ArrayList<Lotto> lottoTickets){
        this.totalAmount = purchaseAmount;
        this.lottoTickets = lottoTickets;
    }

    public int getLottoTicketCount(){
        return lottoTickets.size();
    }

    public List<List<Integer>> getLottoTicketNumbers(){
        List<List<Integer>> lottoTicketNumbers = new ArrayList<>();

        for(Lotto lotto : lottoTickets){
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            lottoTicketNumbers.add(numbers);
        }

        return lottoTicketNumbers;
    }


}
