package lotto.domain;

import java.util.List;
import lotto.generator.LottosGenerator;

public class Lottos {
    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos create(TicketCount ticketCount, LottosGenerator lottosGenerator) {
        return new Lottos(lottosGenerator.generate(ticketCount.getTicketCount()));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
