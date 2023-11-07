package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {
    private List<Lotto> usersLotto = new ArrayList<>();

    private int buyMoney;

    public int getBuyMoney() {
        return buyMoney;
    }

    public void setBuyMoney(int buyMoney) {
        this.buyMoney = buyMoney;
    }

    public List<Lotto> getUsersLotto() {
        return usersLotto;
    }

    public void setUsersLotto(List<Lotto> usersLotto) {
        this.usersLotto = usersLotto;
    }


}
