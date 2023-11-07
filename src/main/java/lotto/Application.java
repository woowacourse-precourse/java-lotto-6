package lotto;

import lotto.converter.ConvertService;
import lotto.lotto.LottoController;
import lotto.lotto.LottoView;
import lotto.user.UserController;
import lotto.user.UserView;

public class Application {
    public static void main(String[] args) {
        ConvertService convertService = new ConvertService();
        UserController userController = new UserController(convertService, new UserView());
        LottoController lottoController = new LottoController(convertService, new LottoView());
        userController.inputMyAsset();
        lottoController.pickLottoNumber();
    }
}
