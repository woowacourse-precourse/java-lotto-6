package lotto;

import lotto.converter.ConvertService;
import lotto.lotto.LottoController;
import lotto.lotto.LottoService;
import lotto.lotto.LottoView;
import lotto.user.UserController;
import lotto.user.UserService;
import lotto.user.UserView;

public class Application {
    public static void main(String[] args) {
        Injector injector = new Injector();
        UserController userController = injector.createUserController();
        LottoController lottoController = injector.createLottoController();
        userController.buyLotto();
        lottoController.pickLottoNumber();
    }
}
