package lotto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.command.Command;
import lotto.controller.config.ControllerConfig;
import lotto.view.View;

public class FrontController {
    private final Map<Command, Controller> controllerMap = new HashMap<>();

    public FrontController(ControllerConfig controllerConfig) {
        controllerMap.put(Command.INPUT_PURCHASE_AMOUNT, controllerConfig.userSaveController());
        controllerMap.put(Command.BUY_LOTTO, controllerConfig.userBuyLottoController());
        controllerMap.put(Command.OUTPUT_USER_LOTTO, controllerConfig.userGetLottoController());
        controllerMap.put(Command.INPUT_BONUS_NUMBER, controllerConfig.winningLottoSaveController());
        controllerMap.put(Command.OUTPUT_WINNING_RESULT, controllerConfig.winningResultController());
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
