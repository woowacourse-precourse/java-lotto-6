package lotto;

import lotto.domain.lotto.LottoView;
import lotto.domain.user.User;
import lotto.domain.user.UserView;
import lotto.global.Injector;

public class Application {
    public static void main(String[] args) {
        Injector injector = new Injector();

        UserView userView = injector.getUserView();
        LottoView lottoView = injector.getLottoView();

        User user = userView.inputUserAssets();

        lottoView.runLotto(user);
        userView.userStats(user);
    }
}
