package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;

public class LottoService {

    private static final LottoService instance = new LottoService(LottoRepository.getInstance());
    private final LottoRepository lottoRepository;

    private LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public static LottoService getInstance() {
        return instance;
    }

    public Lotto createLotto(List<Integer> numbers) {
        Lotto lotto = lottoRepository.createLotto(numbers);
        return lotto;
    }
}
