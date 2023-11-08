package lotto.dto;

import lotto.utils.Parser;

public class Payment {
    private int payment;

    private Payment(String inputValue) {
        try {
            validateNullValue(inputValue);
            validateNoRemainderValue(this.payment);
            this.payment = Parser.parseStringToInt(inputValue);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    void validateNullValue(String value) {
        if (value.isBlank()) throw new IllegalArgumentException("[ERROR] 금액을 정확히 입력해 주세요.");
    }

    void validateNoRemainderValue(int value) {
        if (value % 1000 != 0) throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
    }

    public static Payment create(String inputValue) {
        return new Payment(inputValue);
    }

    public int getPayment() {
        return this.payment;
    }
}
