package lotto.validation;

public class AmountCheckValidator {
    private static final String ERROR = "[ERROR] ";

    public static void validateAmount(int amount) {
        if (amount % 1_000 != 0) {
            throw new IllegalArgumentException(ERROR + "1,000원 단위로 입력해 주세요");
        }
    }
}
