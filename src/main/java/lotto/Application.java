package lotto;

import ui.ExceptionHandler;
import ui.IOView;

public class Application {
    public static void main(String[] args) {
        setExceptionHandler();

        int money = IOView.getMoney();

        // TODO: 프로그램 구현
    }

    private static void setExceptionHandler() {
        ExceptionHandler exceptionHandler = new ExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(exceptionHandler);
    }
}
