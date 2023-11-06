package lotto.controller;

import lotto.io.ConsoleWriter;
import lotto.view.ErrorView;

public abstract class AbstractController implements Controller{
    private final ErrorView errorView = new ErrorView(new ConsoleWriter());

    @Override
    public void process() {
        try {
            doProcess();
        } catch (Exception e) {
            errorView.showErrorMessage(e.getMessage());// Writer 주입해야 한다
            process();
        }
    }

    abstract void doProcess();
}
