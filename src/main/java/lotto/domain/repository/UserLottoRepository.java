package lotto.domain.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import lotto.domain.Lotto;

public class UserLottoRepository {
    private static final int ZERO = 0;
    private static final List<Lotto> userLotto = new ArrayList<>();

    public List<Lotto> save(List<Lotto> lottoList) {
        userLotto.addAll(lottoList);
        return lottoList;
    }

    public List<Lotto> getUserLotto() {
        if (userLotto.size() == ZERO) {
            throw new NoSuchElementException("[ERROR] 유저가 보유한 로또가 없습니다.");
        }
        return new ArrayList<>(userLotto);
    }

    public void clear() {
        userLotto.clear();
    }
}
