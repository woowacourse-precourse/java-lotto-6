package lotto.global;

import lotto.domain.converter.ConvertService;
import lotto.domain.lotto.LottoController;
import lotto.domain.lotto.LottoService;
import lotto.domain.lotto.LottoView;
import lotto.domain.number.LottoNumberService;
import lotto.domain.user.UserController;
import lotto.domain.user.UserService;
import lotto.domain.user.UserView;
import lotto.global.validator.UserViewValidator;

public class Injector {
    private final UserViewValidator userViewValidator = new UserViewValidator();
    private final ConvertService convertService = new ConvertService();
    private final LottoNumberService lottoNumberService = new LottoNumberService();
    private final LottoService lottoService = new LottoService(lottoNumberService);
    private final UserService userService = new UserService(lottoService);
    private final UserController userController = new UserController(convertService, userService);
    private final LottoController lottoController = new LottoController(convertService, lottoService);
    private final LottoView lottoView = new LottoView(lottoController);
    private final UserView userView = new UserView(userController, userViewValidator);

    public UserView getUserView(){
        return this.userView;
    }

    public LottoView getLottoView(){
        return this.lottoView;
    }

}
