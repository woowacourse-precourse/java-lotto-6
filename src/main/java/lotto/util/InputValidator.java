package lotto.util;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public interface InputValidator {

    boolean getInputUntilValid();

    default void getInput(Supplier<String> requestMethod, BiConsumer<InputValidator, String> setInfoMethod) {
        while (getInputUntilValid()) {
            try {
                String input = requestMethod.get();
                setInfoMethod.accept(this, input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
