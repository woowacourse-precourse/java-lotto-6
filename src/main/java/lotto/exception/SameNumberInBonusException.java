package lotto.exception;

public class SameNumberInBonusException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 보너스 번호는 로또 당첨 번호에 존재하지 않는 번호여야 합니다.";

    public SameNumberInBonusException() {
        super(ERROR_MESSAGE);
        System.out.println(ERROR_MESSAGE);
    }
}
