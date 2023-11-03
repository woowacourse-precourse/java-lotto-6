package lotto.request;

import lotto.controller.Command;
import lotto.controller.FrontController;

public abstract class Request {
    private final FrontController frontController;
    protected final Command command;

    protected Request(FrontController frontController, Command command) {
        this.frontController = frontController;
        this.command = command;
    }

    public void process() {
        frontController.service(command, askAndInput());
    }

    protected abstract String askAndInput();
}