package lotto.repository;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {

    private List<Lotto> userLottoList = new ArrayList<>();

    public void save(Lotto lotto) {
        userLottoList.add(lotto);
    }

    public List<Lotto> getUserLottoList() {
        return userLottoList;
    }
}
