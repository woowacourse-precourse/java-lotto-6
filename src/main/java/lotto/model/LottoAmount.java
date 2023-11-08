package lotto.model;

import lotto.constant.LottoConstant;

public class LottoAmount {

    private final int amount;

    public LottoAmount(String amount) {
        validateAmount(amount);
        this.amount = Integer.parseInt(amount);
    }

    public int getAmount() {
        return amount;
    }

    public int getLottoCount() {
        return amount / LottoConstant.PRICE;
    }

    private void validateAmount(String amount) {
        validateIsNumber(amount);
        validateIsPositive(amount);
        validateIsDivisibleThousand(amount);
    }

    private void validateIsNumber(String amount) {
        try {
            Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 금액에 숫자 외의 문자와 공백은 포함될 수 없습니다. 구입 금액을 1000원 단위로 입력해주세요.");
        }
    }

    private void validateIsPositive(String amount) {
        int amountSum = Integer.parseInt(amount);
        if (amountSum <= 0) {
            throw new IllegalArgumentException("로또 금액은 음수일 수 없습니다. 구입 금액을 1000원 단위로 금액을 입력해주세요.");
        }
    }

    private void validateIsDivisibleThousand(String amount) {
        int amountSum = Integer.parseInt(amount);
        if (amountSum % LottoConstant.PRICE != 0) {
            throw new IllegalArgumentException("로또 금액을 1000원 단위로 입력해주세요.");
        }
    }
}
