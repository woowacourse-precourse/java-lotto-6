package lotto.domain.generator;

import lotto.io.OutputHandler;

public interface Generator<TInput, TOutput> {

    TOutput generate();

    boolean validate(TInput input);

    default void handleError(String message) {
        OutputHandler.printErrorMessage(message);
    }
}
