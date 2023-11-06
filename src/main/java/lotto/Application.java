package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoCompany;
import lotto.domain.User;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(User.INSTANCE, LottoCompany.INSTANCE);
        lottoController.run();
    }
}
