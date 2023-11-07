package lotto.exception;

public class AlreadyExistNumberException extends IllegalArgumentException{

    public AlreadyExistNumberException() {
        super("[Error] 중복 없이 수를 입력해주세요.");
    }
}
