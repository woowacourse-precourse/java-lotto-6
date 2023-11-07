package lotto.model;


import static lotto.util.NumberConverter.*;

import java.util.List;

public class UserLottos {
    private List<Lotto> userLottoList;
    private int index;

    public UserLottos(List<Lotto> userLottoList) {
        this.userLottoList = userLottoList;
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
