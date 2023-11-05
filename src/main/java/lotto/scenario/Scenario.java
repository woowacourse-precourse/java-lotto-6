package lotto.scenario;

import lotto.util.ErrorHandler;

@FunctionalInterface
public interface Scenario {
    void play();

    default void playUntilSuccess(ErrorHandler handler) {
        while (true) {
            try {
                play();
                break;
            } catch (IllegalArgumentException exception) {
                handler.handle(exception);
            }
        }
    }
}
