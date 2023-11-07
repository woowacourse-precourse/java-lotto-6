package lotto;

import lotto.domain.lotto.LottoView;
import lotto.domain.user.UserView;
import lotto.global.Injector;

public class Application {
    public static void main(String[] args) {
        Injector injector = new Injector();
        UserView userView = injector.getUserView();
        LottoView lottoView = injector.getLottoView();
        lottoView.runLotto(userView.inputUserAssets());
    }
}
