package lotto.purchasing;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.function.Predicate;
import lotto.Askable;

public class PurchaseAmount implements Askable<String> {
    String input;

    @Override
    public String ask() {
        System.out.println(inputPurchaseAmount);

        do {
            input = readLine();
            input = stripCommas(input);

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
            if (!isThousandUnit.test(input)) {
                throw new IllegalArgumentException(nonThousandUnitError);
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

    private final Predicate<String> isThousandUnit = input -> Integer.parseInt(input) % 1000 == 0;

    private String stripCommas(String input) {
        return input.replaceAll(",", "");
    }

    public String getInput() {
        return input;
    }
}