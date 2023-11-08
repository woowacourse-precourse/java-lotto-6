package lotto.repository;

import java.util.ArrayList;
import java.util.List;

import lotto.model.Lotto;

public class LottoRepository {
    private List<Lotto> userLottoList;
    private int index;

    private static class SingletonUserLottos {
        private static final LottoRepository USER_LOTTOS = new LottoRepository();
    }

    public static LottoRepository getInstance() {
        return SingletonUserLottos.USER_LOTTOS;
    }

    private LottoRepository() {
        userLottoList = new ArrayList<>();
        index = 0;
    }

    public void addLotto(Lotto lotto) {
        userLottoList.add(lotto);
    }

    public Lotto getNextUserLotto() {
        Lotto nextUserLotto = userLottoList.get(index);
        index++;
        return nextUserLotto;
    }

    public Boolean isRemainUserLotto() {
        return (index < userLottoList.size());
    }

    public Integer getNumberOfLotto() {
        return userLottoList.size();
    }

    public void resetIndex() {
        index = 0;
    }
}
