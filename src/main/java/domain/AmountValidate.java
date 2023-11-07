package domain;

public class AmountValidate {

    public void validateAmount(String amount) {
        validateNumberFormat(amount);
        validateAmountUnder(amount);
        validateAmountUnit(amount);
    }

    private void validateNumberFormat(String amount) {
        if (!amount.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력이 가능합니다.");
        }
    }

    private void validateAmountUnder(String amount) {
        if (Integer.parseInt(amount) < 1000) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상이어야 합니다.");
        }
    }

    private void validateAmountUnit(String amount) {
        if (Integer.parseInt(amount) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000 단위여야합니다.");
        }
    }
}

