package lotto.domain;

import lotto.config.ConstantNum;
import lotto.view.InputView;

public class SiteUser {
    private UserMoney userMoney;
    private UserLotto userLotto;
    private int lottoCnt;

    private SiteUser(UserMoney userMoney, UserLotto userLotto, int lottoCnt) {
        this.userMoney = userMoney;
        this.userLotto = userLotto;
        this.lottoCnt = lottoCnt;
    }

    public UserMoney getUserMoney() {
        return userMoney;
    }

    public UserLotto getUserLotto() {
        return userLotto;
    }

    public int getLottoCnt() {
        return lottoCnt;
    }

    public static SiteUser createSiteUser() {
        int money = (int) InputView.INPUT_MONEY.activateView();
        int cnt = money / ConstantNum.PER_PRICE.getNum();
        return new SiteUser(UserMoney.createMoney(money), UserLotto.makeRandomLotto(cnt), cnt);
    }
}
