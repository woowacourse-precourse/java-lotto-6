package lotto.dto;

import lotto.model.Lotto;

import java.util.List;

public class Purchase {
    private List<Lotto> lottos;
    private int count;

    public Purchase() {
    }

    public Purchase(List<Lotto> lottos, int count) {
        this.lottos = lottos;
        this.count = count;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getCount() {
        return count;
    }
}
