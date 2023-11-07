package lotto.constants;

public enum WinningBundleErrorMessage implements ErrorMessage{
    TOTAL_SIZE_INVALID("당첨 번호의 갯수는 총 6개여야 합니다.");

    private final String message;

    WinningBundleErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
