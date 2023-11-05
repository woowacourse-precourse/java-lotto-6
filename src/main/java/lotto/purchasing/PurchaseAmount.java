package lotto.purchasing;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.function.Predicate;
import lotto.Askable;

public class PurchaseAmount implements Askable {
    String input;

    @Override
    public String ask() {
        System.out.println(inputPurchaseAmount);

        do {
            input = readLine();

        } while (!validate(input));

        System.out.println();

        return input;
    }

    private boolean validate(String input) {
        boolean corretInput = true;

        try {
            if (!isPositiveInteger.test(input)) {
                throw new IllegalArgumentException(nonPositiveIntegerError);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            corretInput = false;
        }

        return corretInput;
    }

    private final Predicate<String> isPositiveInteger = input -> {
        try {
            return Integer.parseInt(input) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    };
}