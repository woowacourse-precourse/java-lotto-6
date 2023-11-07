package lotto.game.io;

import java.util.function.Supplier;
import lotto.enums.GlobalMessage;
import lotto.io.ConsoleOutput;

public interface InteractionRepeatable {

    Output output = new ConsoleOutput(); // 아..... 얘때문에 다시 의존성 잡히네

    default void runInteraction(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                break;
            } catch (IllegalArgumentException e) {
                output.println(GlobalMessage.ERROR_HEADER.get() + e.getMessage());
            }
        }
    }

    default <T> T supplyInteraction(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                output.println(GlobalMessage.ERROR_HEADER.get() + e.getMessage());
            }
        }
    }

}
