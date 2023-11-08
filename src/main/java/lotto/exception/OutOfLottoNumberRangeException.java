package lotto.exception;

public class OutOfLottoNumberRangeException extends CustomException {
    public OutOfLottoNumberRangeException(int minRangeValue, int maxRangeValue) {
        super("로또 번호의 값은 " + minRangeValue + "부터 " + maxRangeValue + "까지 입니다.");
    }
}
