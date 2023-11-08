package lotto.exception;

public class SizeNotEqualException extends CustomException {
    public SizeNotEqualException(int fixSize) {
        super("주어진 개수가 " + fixSize + "개가 아닙니다.");
    }
}
