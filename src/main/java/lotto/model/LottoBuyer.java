package lotto.model;

import java.util.List;
import lotto.config.AppConfig;

public class LottoBuyer {

    List<Lotto> lottoTickets;

    public LottoBuyer(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public Lotto getLotto(int index) {
        return lottoTickets.get(index);
    }

    public int size() {
        return lottoTickets.size();
    }

    public int payment() {
        return size() * AppConfig.LOTTO_PRICE;
    }
}
