package lotto.exception;

public class InsideListDuplicatedException extends IllegalArgumentException{
    private static final String MESSAGE = "[ERROR] 당첨 번호 내에 중복된 숫자가 있습니다!";
    public InsideListDuplicatedException() {
        super(MESSAGE);
    }
}
