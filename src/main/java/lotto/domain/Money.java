package lotto.domain;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public Money(String inputMoney) {
        this.money = validateMoney(inputMoney);
    }

    private int validateMoney(String inputMoney) {
        validateEmpty(inputMoney);
        validateNull(inputMoney);
        return validateInteger(inputMoney);
    }

    private void validateEmpty(String inputMoney) {
        if (inputMoney.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 금액은 입력 불가");
        }
    }

    private void validateNull(String inputMoney) {
        if (inputMoney == null) {
            throw new IllegalArgumentException("null 입력 불가");
        }
    }

    private int validateInteger(String inputMoney) {
        int parsedMoney;
        try {
            parsedMoney = Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능");
        }

        if (parsedMoney <= 0 || parsedMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("금액은 1000원 단위 양수만 가능");
        }
        return parsedMoney;
    }
}
