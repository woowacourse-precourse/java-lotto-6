package lotto.util;

import lotto.view.output.OutputView;
import java.util.function.Supplier;

public class ExecuteUntilSuccess {
    // This is the common method that both public method overloads will use
    private static <R> R executeWithRetry(OutputFunction output,
            Supplier<R> executionLogic) {
        R result = null;
        boolean executeUntilSuccess = true;
        while (executeUntilSuccess) {
            try {
                output.execute();
                result = executionLogic.get(); // Use the Supplier to execute the logic
                executeUntilSuccess = false;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
        OutputView.printNewLine();
        return result;
    }

    // This method does not have the additional argument
    public static <T, R> R execute(OutputFunction output, InputFunction<T> input, FactoryFunction<R, T> validator) {
        return executeWithRetry(output, () -> validator.execute(input.execute()));
    }

    // This method includes the additional argument
    public static <T, R, A> R executeWithArgument(OutputFunction output, InputFunction<T> input,
            FactoryFunctionWithArgument<R, T, A> validator, A argument) {
        return executeWithRetry(output, () -> validator.execute(input.execute(), argument));
    }
}
