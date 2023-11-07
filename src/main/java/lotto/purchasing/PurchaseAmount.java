package lotto.purchasing;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.function.Predicate;
import lotto.Askable;

public class PurchaseAmount implements Askable<Integer> {
    @Override
    public Integer ask() {
        System.out.println(INPUT_PURCHASE_AMOUNT);

        String input;
        do {
            input = readLine();
            input = stripCommas(input);

        } while (!validate(input));

        System.out.println();

        return Integer.parseInt(input);
    }

    private boolean validate(String input) {
        boolean corretInput = true;

        try {
            if (!isPositiveInteger.test(input)) {
                throw new IllegalArgumentException(NON_POSITIVE_INTEGER_ERROR);
            }
            if (!isThousandUnit.test(input)) {
                throw new IllegalArgumentException(NON_THOUSAND_UNIT_ERROR);
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
}