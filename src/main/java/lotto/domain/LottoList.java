package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private final List<Lotto> lottoList;

    public LottoList() {
        lottoList = new ArrayList<>();
    }

    public void insertLotto(Lotto lotto) {
        lottoList.add(lotto);
    }

    public int getSize() {
        return lottoList.size();
    }

    public List<Lotto> getAllLotto() {
        return lottoList;
    }
}
