package lotto.repository;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {

    List<Lotto> lottoDatabase = new ArrayList<>();

    public void save(Lotto lotto) {
        lottoDatabase.add(lotto);
    }

    public void save(List<Lotto> lottos){
        lottoDatabase.addAll(lottos);
    }

    public List<Lotto> findAll(){
        return lottoDatabase;
    }
}
