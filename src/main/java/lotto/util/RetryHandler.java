package lotto.util;

import java.util.function.Function;
import java.util.function.Supplier;
import lotto.config.AppConfig;
import lotto.domain.UserInterface;

public class RetryHandler {

    private static final UserInterface userInterface = AppConfig.userInterface();

    public static <T> T retryOnException(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException exception) {
                userInterface.printErrorMessage(exception);
            }
        }
    }

    public static <T, R> R retryOnException(Function<T, R> inputModifier, T input) {
        while (true) {
            try {
                return inputModifier.apply(input);
            } catch (IllegalArgumentException exception) {
                userInterface.printErrorMessage(exception);
            }
        }
    }
}
