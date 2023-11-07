package lotto.domain.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class UserLottoRepository {
    private static final List<Lotto> userLotto = new ArrayList<>();

    public List<Lotto> save(List<Lotto> lottoList) {
        userLotto.addAll(lottoList);
        return lottoList;
    }

    public List<Lotto> getUserLotto() {
        return new ArrayList<>(userLotto);
    }
}
