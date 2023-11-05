package lotto;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoDTO> getLottoDTOs() {
        return lottos.stream()
                .map(LottoDTO::from)
                .toList();
    }
}