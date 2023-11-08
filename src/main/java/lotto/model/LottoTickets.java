package lotto.model;

import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<List<Integer>> lottoTickets;

    public LottoTickets(List<List<Integer>> lottoTickets, List<Integer> lottoNumbers) {
        lottoTickets.add(lottoNumbers);
        this.lottoTickets = lottoTickets;
    }

    public List<List<Integer>> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

}
