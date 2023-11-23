package lotto;

import lotto.controller.Controller;

public class Application {
    private final Controller controller;

    public Application(final AppConfig appConfig) {
        this.controller = appConfig.controller;
    }

    public static void main(String[] args) {
        Application application = new Application(AppConfig.getInstance());
        application.run();
    }

    public void run() {
        controller.run();
    }
}
