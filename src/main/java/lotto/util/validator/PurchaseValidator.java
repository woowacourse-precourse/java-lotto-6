package lotto.util.validator;

import lotto.domain.Purchase;

public class PurchaseValidator implements Validator {
    @Override
    public void validate(Object value) {
        validatePositiveNumber((int) value);
        validateUnit((int) value);
    }

    private void validatePositiveNumber(int value) {
        if (!isPositiveNumber(value)) {
            throw new IllegalArgumentException("0보다 큰 숫자로 입력해야 합니다.");
        }
    }

    private static boolean isPositiveNumber(int value) {
        return value > 0;
    }

    private void validateUnit(int value) {
        if (!isValidUnit(value)) {
            throw new IllegalArgumentException("1000원 단위의 숫자로 입력해야 합니다.");
        }
    }

    private boolean isValidUnit(int value) {
        return value % 1000 == 0;
    }

    @Override
    public boolean support(Class<?> clazz) {
        return Purchase.class.isAssignableFrom(clazz);
    }
}
