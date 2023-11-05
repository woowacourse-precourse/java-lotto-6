package lotto.input;

import java.util.function.Supplier;

final class InputRetryHelper<E> {
    private int retryCount = 0;

    E retry(Supplier<E> supplier) {
        retryCount = 0;
        E result = null;
        while (result == null) {
            result = useSupplier(supplier);
        }
        return result;
    }

    private E useSupplier(Supplier<E> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            retryCount++;
        }
        return null;
    }

    int getRetryCount() {
        return retryCount;
    }
}
