package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;

public class LottoServiceImpl implements LottoService {
    private final LottoRepository lottoRepository;

    public LottoServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    @Override
    public void recordLotto(Lotto lotto) {
        lottoRepository.save(lotto);
    }

    @Override
    public List<Lotto> getAllLottoRecord() {
        List<Lotto> lottos = lottoRepository.getLottoList();
        return lottos;
    }
}
