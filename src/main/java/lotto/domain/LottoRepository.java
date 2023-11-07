package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    private final List<Lotto> lottoRepository;

    public LottoRepository(List<Lotto> lottoList){
        this.lottoRepository = lottoList;
    }

    public List<Lotto> getLottoRepository() {
        return lottoRepository;
    }

}
