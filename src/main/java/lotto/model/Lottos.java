package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    public List<Lotto> lottos;
    public List<Lotto> buyLottoByTicketAmount(Integer ticketAmount) {
        List<Lotto> arr = new ArrayList<>();
        IntStream.range(0,ticketAmount).forEach(i->arr.add(Lotto.newInstance()));
        this.lottos = List.copyOf(arr);
        return this.lottos;
    }
}
