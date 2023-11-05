package lotto.common.validator;

public class NumericValidator {

    private NumericValidator() {
    }

    public static void validateDivisible(int dividend, int divisor) {
        if (Math.floorMod(dividend, divisor) != 0) {
            throw new IllegalArgumentException(
                    "Dividend %d is not divisible by divisor %d.".formatted(dividend, divisor)
            );
        }
    }

}
