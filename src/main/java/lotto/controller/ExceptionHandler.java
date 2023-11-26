package lotto.controller;

import java.util.function.Supplier;
import lotto.exception.custom.CustomIllegalArgumentException;
import lotto.exception.custom.CustomIllegalStateAmountException;
import lotto.exception.custom.CustomNullPointAmountException;
import lotto.exception.custom.CustomNumberFormatAmountException;

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
