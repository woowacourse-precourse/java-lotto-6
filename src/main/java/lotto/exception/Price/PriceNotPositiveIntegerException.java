package lotto.exception.Price;

public class PriceNotPositiveIntegerException extends IllegalArgumentException {

    public PriceNotPositiveIntegerException() {
        super("[ERROR] 로또 구입 가격이 양의 정수로 입력해야 합니다.");
    }
}
