package lotto.app.game.io;

import java.util.function.Supplier;
import lotto.app.enums.GlobalMessage;
import lotto.app.io.ConsoleOutput;

public interface InteractionRepeatable {

    Output output = new ConsoleOutput();

    default void runInteraction(final Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                break;
            } catch (IllegalArgumentException e) {
                output.println(GlobalMessage.ERROR_HEADER.get() + e.getMessage());
            }
        }
    }

    default <T> T supplyInteraction(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                output.println(GlobalMessage.ERROR_HEADER.get() + e.getMessage());
            }
        }
    }

}
