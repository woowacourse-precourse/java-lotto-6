package lotto.exception;

public class InvalidUnitException extends IllegalArgumentException{
    public InvalidUnitException() {
        super("[ERROR] 구입 금액은 천원 단위로 입력할 수 있습니다.\n");
    }
}
