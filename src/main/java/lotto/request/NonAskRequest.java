package lotto.request;

import lotto.controller.Command;
import lotto.controller.FrontController;

public class NonAskRequest extends Request {

    public NonAskRequest(FrontController frontController, Command command) {
        super(frontController, command);
    }

    @Override
    protected String askAndInput() {
        return null;
    }
}
