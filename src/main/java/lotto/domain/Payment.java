package lotto.domain;

import lotto.utils.Parser;

public class Payment {
    private int amount;

    public Payment(String inputValue){
        validateNullValue(inputValue);
        this.amount = Parser.parseStringToInt(inputValue);
        validateNoRemainderValue(this.amount);
    }

    void validateNullValue(String value) {
        if (value.isBlank()) throw new IllegalArgumentException("[ERROR] 금액을 정확히 입력해 주세요.");
    }

    void validateNoRemainderValue(int value) {
        if (value % 1000 != 0) throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
    }

    public int getAmount() {
        return amount;
    }
}
