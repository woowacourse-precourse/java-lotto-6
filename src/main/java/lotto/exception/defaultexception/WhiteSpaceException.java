package lotto.exception.defaultexception;

public class WhiteSpaceException extends LottoDefaultException{
    public WhiteSpaceException() {
        super("[ERROR] 입력값에 공백이 포함되어 있습니다.");
    }
}
