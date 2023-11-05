package lotto.exception;

public enum RankException implements CustomException {

    INVALID_CONDITION("로또 당첨 조건과 일치하는 결과가 없습니다.");

    private final String message;

    RankException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
