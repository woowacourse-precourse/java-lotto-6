package lotto.exception;

public class SameNumberInLottoException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 로또 당첨 번호 안에 중복된 수가 있을 수 없습니다.";

    public SameNumberInLottoException() {
        super(ERROR_MESSAGE);
        System.out.println(ERROR_MESSAGE);
    }
}
