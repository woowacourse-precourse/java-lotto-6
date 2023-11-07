package lotto.exception.Price;

public class PriceNotInRangeException extends IllegalArgumentException {

    public PriceNotInRangeException() {
        super("[ERROR] 로또 구입 가격은 양의 정수로 입력해야 합니다.");
    }
}
