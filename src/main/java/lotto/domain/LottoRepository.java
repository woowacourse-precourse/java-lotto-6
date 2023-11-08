package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    private final List<Lotto> lottoRepository;

    public LottoRepository(){
        lottoRepository = new ArrayList<>();
    }

    public List<Lotto> getLottoRepository() {
        return lottoRepository;
    }
    public void addOne(Lotto lotto){
        lottoRepository.add(lotto);
    }

}
