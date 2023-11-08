package lotto.exception.Price;

public class PriceNot1KsException extends IllegalArgumentException {

    public PriceNot1KsException() {
        super("[ERROR] 로또 구입 가격은 1,000 단위로 입력해야 합니다.");
    }
}
