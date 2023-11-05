package lotto.domain;

import lotto.utils.Parser;

public class PurchaseAmount {
    int amount;

    PurchaseAmount(String inputValue){
        validateNullValue(inputValue);
        validNoIntegerValue(inputValue);
        validateNoRemainderValue(this.amount);
        this.amount = Parser.parseStringToInt(inputValue);
    }

    void validateNullValue(String value) {
        if (value.isBlank()) throw new IllegalArgumentException("[ERROR] 금액을 정확히 입력해 주세요.");
    }

    void validateNoRemainderValue(int value) {
        if (value % 1000 != 0) throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
    }

    void validNoIntegerValue(String value) {
        try {
            int intValue = Integer.parseInt(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 정수값을 입력해 주세요.");
        }
    }

    public int getAmount() {
        return amount;
    }
}
