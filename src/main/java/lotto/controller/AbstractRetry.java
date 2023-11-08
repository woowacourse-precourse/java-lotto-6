package lotto.controller;

import static lotto.constant.ErrorMessage.EXCEEDING_MAX_RETRY;

import java.util.Objects;
import java.util.function.Supplier;
import lotto.constant.MaxRetry;

public abstract class AbstractRetry {
    public <T> T run(final Supplier<T> supplier) {
        Objects.requireNonNull(supplier);
        int retryCount = 0;
        while (MaxRetry.COUNT.isBelow(retryCount)) {
            try {
                return supplier.get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            retryCount++;
            validateRetryCount(MaxRetry.COUNT.getValue(), retryCount);
        }
        throw new ExceedingMaxRetryException();
    }

    private void validateRetryCount(final int maxRetryCount, final int retryCount) {
        if (retryCount == maxRetryCount) {
            throw new ExceedingMaxRetryException();
        }
    }

    protected static class ExceedingMaxRetryException extends IllegalStateException {
        public ExceedingMaxRetryException() {
            super(EXCEEDING_MAX_RETRY.getMessage());
        }
    }
}
