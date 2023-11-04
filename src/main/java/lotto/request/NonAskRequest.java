package lotto.request;

import java.util.List;
import lotto.command.Command;
import lotto.controller.FrontController;

public class NonAskRequest extends Request {

    public NonAskRequest(FrontController frontController, Command command) {
        super(frontController, command);
    }

    @Override
    protected List<String> askAndInput() {
        return null;
    }
}
