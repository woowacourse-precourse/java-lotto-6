package lotto.repository;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {

    private List<Lotto> userLottoList = new ArrayList<>();
    private Lotto winningLotto;

    private int bounsNum;

    public void save(Lotto lotto) {
        userLottoList.add(lotto);
    }

    public void setWinningLotto(Lotto lotto) {
        winningLotto = lotto;
    }

    public void setBounsNum(int num) {
        bounsNum = num;
    }

    public List<Lotto> getUserLottoList() {
        return userLottoList;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNum() {
        return bounsNum;
    }
}
