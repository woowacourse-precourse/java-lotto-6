package lotto;

public final class Error {
    private static final String PREFIX = "[ERROR] ";
    private static final String SUFFIX = "\n";

    public enum Domain {
        DUPLICATED_LOTTO_NUMBER("중복된 로또 번호가 있습니다."),
        WRONG_LOTTO_NUMBER_LENGTH("한 로또에는 총 6자리를 입력해야합니다."),
        WRONG_LOTTO_SIZE("로또 숫자로는 1 ~ 45 사이에 숫자만 가능합니다.");
        private final String message;

        Domain(String message) {
            this.message = message;
        }

        public String getMessage() {
            return PREFIX + message + SUFFIX;
        }
    }
}
