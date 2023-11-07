package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket(int count) {
        this.lottos = IntStream.range(0, count)
                .mapToObj(i -> new Lotto())
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
