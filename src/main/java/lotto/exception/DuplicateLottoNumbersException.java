package lotto.exception;

public class DuplicateLottoNumbersException extends RuntimeException {
    public DuplicateLottoNumbersException(String message) {
        super(message);
        System.out.println("로또 번호에 중복된 값이 있습니다.");
    }
}

