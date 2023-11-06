package lotto.exception;

public enum ExceptionManager {

    BEGIN_ERROR("[ERROR] ");

    private final String beginMsg;

    ExceptionManager(String beginMsg) {
        this.beginMsg = beginMsg;
    }

    public IllegalArgumentException createIllegalArgumentException(String detailMag) {
        return new IllegalArgumentException(beginMsg + detailMag);
    }
}
