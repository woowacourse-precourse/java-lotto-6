package lotto;

import lotto.controller.Controller;
import lotto.domain.LottoCompany;
import lotto.domain.LottoWallet;
import lotto.domain.User;
import lotto.domain.UserPrize;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(
                new User(new LottoWallet(), new UserPrize()),
                LottoCompany.INSTANCE
        );
        controller.run();
    }
}
