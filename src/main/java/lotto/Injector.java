package lotto;

import lotto.converter.ConvertService;
import lotto.lotto.LottoController;
import lotto.lotto.LottoService;
import lotto.lotto.LottoView;
import lotto.number.LottoNumberService;
import lotto.user.UserController;
import lotto.user.UserService;
import lotto.user.UserView;

public class Injector {
    private final ConvertService convertService = new ConvertService();
    private final UserView userView = new UserView();
    private final LottoView lottoView = new LottoView();
    private final LottoNumberService lottoNumberService = new LottoNumberService();
    private final LottoService lottoService = new LottoService(lottoNumberService);
    private final UserService userService = new UserService(lottoService);

    public UserController createUserController() {
        return new UserController(convertService, userView, userService);
    }

    public LottoController createLottoController() {
        return new LottoController(convertService, lottoView, lottoService);
    }
}
