package lotto.model.domain.vo;

import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public int getEA() {
        return lottos.size();
    }

    public List<List<Integer>> getHistory() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .toList();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
