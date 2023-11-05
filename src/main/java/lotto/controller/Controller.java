package lotto.controller;

import lotto.view.View;
import lotto.view.constant.Message;

public class Controller {

    private final static View view = new View();
    public void start() {
        view.output(Message.INPUT_COST);
    }
}
