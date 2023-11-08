package lotto.controller;

import static lotto.constant.ErrorMessage.EXCEEDING_MAX_RETRY;

import java.util.function.Supplier;

public abstract class AbstractRetry {
    public <T> T run(final int maxRetryCount, final Supplier<T> supplier) {
        int retryCount = 0;
        T output = null;

        while (retryCount < maxRetryCount) {
            try {
                output = supplier.get();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                retryCount++;
                validateRetryCount(maxRetryCount, retryCount);
            }
        }

        return output;
    }

    private void validateRetryCount(final int maxRetryCount, final int retryCount) {
        if (retryCount == maxRetryCount) {
            throw new ExceedingMaxRetryException();
        }
    }

    protected static class ExceedingMaxRetryException extends RuntimeException {
        public ExceedingMaxRetryException() {
            super(EXCEEDING_MAX_RETRY.getMessage());
        }
    }
}
