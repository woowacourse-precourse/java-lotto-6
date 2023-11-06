package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoCompany;
import lotto.domain.LottoWallet;
import lotto.domain.User;
import lotto.domain.UserPrize;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new User(new LottoWallet(), new UserPrize()),
                LottoCompany.INSTANCE
        );
        lottoController.run();
    }
}
