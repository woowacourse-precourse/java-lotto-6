package lotto.controller.config;

import lotto.controller.lotto.WinningLottoSaveController;
import lotto.controller.result.WinningResultController;
import lotto.controller.user.UserBuyLottoController;
import lotto.controller.user.UserGetLottoController;
import lotto.controller.user.UserSaveController;
import lotto.repository.UserRepository;
import lotto.repository.WinningLottoRepository;
import lotto.service.LottoService;
import lotto.service.UserService;
import lotto.service.WinningLottoService;

public class ControllerConfig {
    public WinningResultController winningResultController() {
        return new WinningResultController(
                new WinningLottoService(new WinningLottoRepository()),
                new UserService(new UserRepository(), new LottoService())
        );
    }

    public WinningLottoSaveController winningLottoSaveController() {
        return new WinningLottoSaveController(new WinningLottoService(new WinningLottoRepository()));
    }

    public UserBuyLottoController userBuyLottoController() {
        return new UserBuyLottoController(new UserService(new UserRepository(), new LottoService()));
    }

    public UserGetLottoController userGetLottoController() {
        return new UserGetLottoController(new UserService(new UserRepository(), new LottoService()));
    }

    public UserSaveController userSaveController() {
        return new UserSaveController(new UserService(new UserRepository(), new LottoService()));
    }
}
