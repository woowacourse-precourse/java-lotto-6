package lotto.controller.register;

import lotto.io.ConsoleWriter;
import lotto.view.ErrorView;

public abstract class RegisterAbstractController<E> implements RegisterController<E> {
    private final ErrorView errorView = new ErrorView(new ConsoleWriter());

    @Override
    public E process() {
        try {
            return doProcess();
        } catch (Exception e) {
            errorView.showErrorMessage(e.getMessage());
            return process();
        }
    }

    abstract E doProcess();
}
