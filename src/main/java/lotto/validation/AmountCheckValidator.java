package lotto.validation;

public class AmountCheckValidator {
    public static boolean validateAmount(int amount) {
        return amount % 1_000 != 0;
    }
}
