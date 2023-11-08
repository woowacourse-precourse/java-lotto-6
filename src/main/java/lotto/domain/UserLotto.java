package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class UserLotto {

    private Lotto userLotto;
    private Integer bonusNumber;

    public UserLotto(List<Integer> userLotto, Integer bonusNumber){
        this.userLotto = new Lotto(userLotto);
        this.bonusNumber = bonusNumber;
    }

//    public Lotto getUserNumbers() {
//        return userLotto;
//    }

    public boolean isContain(int number) {
        return userLotto.isContain(number);
    }
    public int getBonusNumber() {
        return bonusNumber;
    }
}

