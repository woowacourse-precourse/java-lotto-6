package lotto.controller;

import lotto.view.outputview.ErrorHandlingView;

public final class ErrorHandler {
    private ErrorHandler() {
    }

    public static void tryUntilNoError(Runnable method) {
        try {
            method.run();
        } catch (IllegalArgumentException e) {
            ErrorHandlingView.viewErrorText(e.getMessage());
            tryUntilNoError(method);
        }
    }
}
