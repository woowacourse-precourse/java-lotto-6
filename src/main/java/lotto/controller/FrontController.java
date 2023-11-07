package lotto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.command.Command;
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
import lotto.view.View;

public class FrontController {
    private final Map<Command, Controller> controllerMap = new HashMap<>();

    public FrontController() {
        controllerMap.put(Command.INPUT_PURCHASE_AMOUNT, new UserSaveController(new UserService(new UserRepository(),
                new LottoService())));
        controllerMap.put(Command.BUY_LOTTO, new UserBuyLottoController(new UserService(new UserRepository(), new LottoService())));
        controllerMap.put(Command.OUTPUT_USER_LOTTO, new UserGetLottoController(new UserService(new UserRepository(), new LottoService())));
        controllerMap.put(Command.INPUT_BONUS_NUMBER, new WinningLottoSaveController(new WinningLottoService(new WinningLottoRepository())));
        controllerMap.put(Command.OUTPUT_WINNING_RESULT, new WinningResultController(
           new WinningLottoService(new WinningLottoRepository()),
           new UserService(new UserRepository(), new LottoService())
        ));
    }

    public void service(Command command, List<String> input) {

        Controller controller = controllerMap.get(command);
        if(controller == null) {
            return;
        }

        View view = controller.process(input);
        view.render();
    }
}
