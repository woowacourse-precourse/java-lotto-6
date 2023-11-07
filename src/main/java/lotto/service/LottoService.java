package lotto.service;

import lotto.domain.Lottos;
import lotto.dto.response.LottosResponseDto;
import lotto.repository.LottoRepository;

public class LottoService {

    private final LottoRepository lottoRepository = new LottoRepository();

    public LottosResponseDto buyLotto(int money) {
        Lottos lottos = Lottos.createLotto(money);
        lottoRepository.saveAll(lottos);
        return lottos.toResponse();
    }
}
