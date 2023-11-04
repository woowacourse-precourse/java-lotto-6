package lotto.model;

import java.util.List;
import java.util.stream.Stream;
import lotto.config.AppConfig;

public class LottoBuyer {

    private List<Lotto> lottoTickets;

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

    public Stream<Stream<Integer>> streamOfStream() {
        return lottoTickets.stream()
                .map(Lotto::stream);
    }
}
