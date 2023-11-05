package lotto.domain;

import java.util.List;

public class LottosDTO {

    private final List<List<Integer>> lottos;

    public LottosDTO(List<List<Integer>> lottos) {
        this.lottos = lottos;
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }
}
