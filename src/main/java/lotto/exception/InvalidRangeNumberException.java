package lotto.exception;

public class InvalidRangeNumberException  extends IllegalArgumentException{

    public InvalidRangeNumberException() {
        super("[Error] 1 ~ 45 사이의 숫자만 입력해주세요.");
    }
}
