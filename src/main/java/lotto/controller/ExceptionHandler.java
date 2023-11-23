package lotto.controller;

import java.util.function.Supplier;
import lotto.exception.CustomIllegalArgumentException;
import lotto.exception.CustomIllegalStateAmountException;
import lotto.exception.CustomNullPointAmountException;
import lotto.exception.CustomNumberFormatAmountException;

public class ExceptionHandler {

    private ExceptionHandler() {
    }

    public static <T> T handle(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (CustomNumberFormatAmountException | CustomNullPointAmountException |
                     CustomIllegalArgumentException | CustomIllegalStateAmountException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
