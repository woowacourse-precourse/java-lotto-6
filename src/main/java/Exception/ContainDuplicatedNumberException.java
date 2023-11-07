package Exception;

public class ContainDuplicatedNumberException extends IllegalArgumentException {
    private static final String ERROR = "[ERROR] 로또는 중복된 번호를 가질 수 없습니다.";

    public ContainDuplicatedNumberException() {
        super(ERROR);
    }
}
