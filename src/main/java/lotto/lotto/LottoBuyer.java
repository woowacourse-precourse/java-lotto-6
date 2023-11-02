package lotto.lotto;

import java.util.List;

public class LottoBuyer {

    List<Lotto> lottoTickets;

    Lotto get(int index) {
        return lottoTickets.get(index);
    }

    int size() {
        return lottoTickets.size();
    }
}
