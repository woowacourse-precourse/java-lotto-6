package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;

public class LottoRepositoryDto {
    private List<Lotto> lottos;

    public LottoRepositoryDto(List<Lotto> lottos){
        this.lottos =lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
