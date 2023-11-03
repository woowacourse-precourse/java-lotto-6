package lotto.lotto;

import java.util.List;
import java.util.stream.Stream;
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
