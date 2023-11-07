package lotto.utils;

import java.util.function.Supplier;

public class RetryExecutor {
    private RetryExecutor() {
    }

    @SafeVarargs
    public static <T> T execute(Supplier<T> action, Class<? extends Exception>... exceptionClasses) {
        try {
            return action.get();

        } catch (Exception e) {
            if (isExpectedException(e, exceptionClasses)) {
                System.out.println(e.getMessage());
                return execute(action, exceptionClasses);
            }

            throw e;
        }
    }

    private static boolean isExpectedException(Exception e, Class<? extends Exception>[] exceptionClasses) {
        for (Class<? extends Exception> exceptionClass : exceptionClasses) {
            if (exceptionClass.isInstance(e)) {
                return true;
            }
        }

        return false;
    }
}