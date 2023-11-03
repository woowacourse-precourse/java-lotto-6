package lotto.model.repository;

import lotto.dto.LottoDto;
import lotto.model.domain.Lottos;

public class LottoRepository {
    private final Lottos lottos = new Lottos();

    public void save(LottoDto lottoDto) {
        lottos.addLotto(lottoDto.getLottoNumbers());
    }
}
