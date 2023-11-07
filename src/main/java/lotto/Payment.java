package lotto;

public class Payment {
    private static final int PAYMENT_LIMIT = 100000;
    private static final int NO_CHANGES = 0;
    private final int value;

    Payment(String value){
        validateNumberFormat(value);
        this.value = Integer.parseInt(value);
        validatePaymentUnit(this.value);
        validateAmountLimit(this.value);
    }

    private void validateNumberFormat(String value){
        try {
            Integer.parseInt(value);
        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }

    private void validatePaymentUnit(int payment) {
        int changes = payment % Lotto.PRICE;
        if (changes != NO_CHANGES) {
            throw new IllegalArgumentException("[ERROR] 천원 단위로 구입 가능합니다.");
        }
    }

    private void validateAmountLimit(int payment) {
        if (payment > PAYMENT_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 한번 최대 구입 금액은 10만원 입니다.");
        }
    }

    public int getValue(){
        return this.value;
    }
}
