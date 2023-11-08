package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoCollector {

    private final List<Lotto> lottos;

    public LottoCollector(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getTicketCount() {
        return lottos.size();
    }

    public String convertLottoToString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto).append("\n");
        }

        return sb.toString();
    }

    public List<Lotto> getPublishedLotto() {
        return new ArrayList<>(this.lottos);
    }
}
