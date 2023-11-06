package Exception;

public class InvalidLottoNumberCountException extends IllegalArgumentException {
    private static final String ERROR = "[ERROR] 로또 번호는 6개입니다.";

    public InvalidLottoNumberCountException() {
        super(ERROR);
    }
}
