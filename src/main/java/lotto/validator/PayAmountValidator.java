package lotto.validator;

public class PayAmountValidator {
    public void validate(String purchaseAmount) {
        isBlank(purchaseAmount);
        isNotNumeric(purchaseAmount);
        cannotDivideOneThousand(purchaseAmount);
    }

    private void isBlank(String purchaseAmount) {
        if (purchaseAmount == null || purchaseAmount.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구매 금액을 입력하세요. 값이 null 또는 빈 값일 수 없습니다.");
        }
    }

    private void isNotNumeric(String purchaseAmount) {
        if (!purchaseAmount.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자만 입력 가능합니다.");
        }
    }

    private void cannotDivideOneThousand(String purchaseAmount) {
        if (!purchaseAmount.matches("[0-9]*000")) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 입력해주세요.");
        }
    }
}
