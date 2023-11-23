package lotto.controller;

import java.util.function.Supplier;
import lotto.exception.exceptions.CustomIllegalArgumentException;
import lotto.exception.exceptions.CustomIllegalStateAmountException;
import lotto.exception.exceptions.CustomNullPointAmountException;
import lotto.exception.exceptions.CustomNumberFormatAmountException;

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
