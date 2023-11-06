package lotto.model.service;

import lotto.model.domain.Rank;
import lotto.model.domain.User;
import lotto.view.InputView;

public class UserService {
    InputView inputView = new InputView();

    public User setUserInfo() {

        return new User(inputView.readPurchaseMoney());
    }

    public void updateUserRank(User user, int identifyNum) {
        Rank rank = Rank.lottoRank(identifyNum);
        user.increaseMoneyOfReturn(rank.getPrize());
        user.increaseUserRank(identifyNum);
    }
}
