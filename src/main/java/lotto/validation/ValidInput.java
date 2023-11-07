package lotto.validation;

public class ValidInput {

    public void validPayment(String payment) {
        if (!payment.matches("\\d+"))
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        else if (!(Integer.parseInt(payment) % 1000 == 0)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000 단위로 입력해야 합니다.");
        }
    }

    public void validNumber(String str) {
        if (!str.matches("\\d+"))
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
    }

    public void validBonusNumber(String bonusNumber) {
        if (!bonusNumber.matches("\\d+"))
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        else if (Integer.parseInt(bonusNumber) < 1 || Integer.parseInt(bonusNumber) > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

}
