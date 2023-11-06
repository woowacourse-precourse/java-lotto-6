package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Condition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoTickets extends Condition<LottoTickets> {
    private List<Lotto> tickets = new ArrayList<>();

    public LottoTickets(int amount) {
        for(int i=0; i<amount; i++){
            Lotto lottoTicket = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            tickets.add(lottoTicket);
        }
    }

    public LottoTickets(List<Lotto> lotto){
        this.tickets = lotto;
    }

    @Override
    public boolean equals(Object obj) {
        LottoTickets input = (LottoTickets) obj;
        return IntStream.range(0, input.tickets.size()).allMatch(i -> tickets.get(i).equals(input.tickets.get(i)));
    }
}
