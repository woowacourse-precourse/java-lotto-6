package lotto.repository;

import java.util.List;
import lotto.domain.Lotto;

public class LottoRepository {
    private static List<Lotto> myLotto;

    public void save(List<Lotto> myLotto){
        LottoRepository.myLotto = myLotto;
    }

    public List<Lotto> getMyLotto(){
        return myLotto;
    }
}
