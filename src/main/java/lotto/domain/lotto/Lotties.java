package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.dto.LottoDto;

public class Lotties {
    private final List<Lotto> lotties;

    public Lotties() {
        this.lotties = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lotties.add(lotto);
    }

    public LottoDto makeLottoDto() {
        return new LottoDto(lotties);
    }
}
