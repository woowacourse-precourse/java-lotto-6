package lotto;

import java.util.List;

public class Money {

    public String amount;

    public Money(String amount) {
        validateFormat(amount);
        validateNumber(amount);
        this.amount = amount;
    }

    private void validateFormat(String amount) {
        if (!amount.matches("[0-9]+")){
            throw new IllegalArgumentException("[ERROR] 입력 형식에 맞지 않습니다.");
        }
    }

    private void validateNumber(String amount) {
        if (Integer.parseInt(amount) % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지지 않습니다.");
        }
    }
}
