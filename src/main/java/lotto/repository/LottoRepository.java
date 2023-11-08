package lotto.repository;

import java.util.ArrayList;
import java.util.List;

import lotto.model.Lotto;

public class LottoRepository {
    private List<Lotto> userLottoList;

    private static class SingletonUserLottos {
        private static final LottoRepository USER_LOTTOS = new LottoRepository();
    }

    public static LottoRepository getInstance() {
        return SingletonUserLottos.USER_LOTTOS;
    }

    private LottoRepository() {
        userLottoList = new ArrayList<>();
    }

    public void saveLotto(Lotto lotto) {
        userLottoList.add(lotto);
    }

    public Lotto findUserLottoByIndex(int index) {
        return userLottoList.get(index);
    }

    public Integer findNumberOfUserLotto() {
        return userLottoList.size();
    }
    public void clear(){
        userLottoList.clear();
    }

}
