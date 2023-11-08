package lotto.exception.state;

public class NonVariableException extends BaseIllegalStateException {
    private static final String MESSAGE = "필요한 정보가 비어있습니다.\n빈 변수:%s";

    /**
     * 변수가 빈 경우 예외, 해당 변수명을 파라미터로 추가
     *
     * @param variable 변수명
     */
    public NonVariableException(String variable) {
        super(String.format(MESSAGE, variable));
    }

}
