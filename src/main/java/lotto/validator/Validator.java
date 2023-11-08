package lotto.validator;

public class Validator {
    public void validateLotteryPrice(int price) {
        if (price == 0 || price % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 이루어져야 합니다.");
        }
    }
}
