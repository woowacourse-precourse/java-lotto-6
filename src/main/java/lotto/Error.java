package lotto;

public final class Error {
    private static final String PREFIX = "[ERROR] ";

    public enum Domain {
        SAME_LOTTO_NUMBER("중복된 로또 번호가 있습니다."),
        WRONG_LOTTO_SIZE("한 로또에는 총 6자리를 입력해야합니다."),
        WRONG_LOTTO_NUMBER_RANGE("로또 숫자로는 1 ~ 45 사이에 숫자만 가능합니다."),
        EMPTY_LOTTO("구입한 로또가 없습니다."),
        WRONG_PRICE("구입 금액은 %d 단위여야 합니다."),
        BONUS_NUMBER_ALREADY_EXIST("정답 로또 번호에 보너스 번호가 이미 존재합니다.");
        private final String text;

        Domain(String text) {
            this.text = text;
        }

        public String getText() {
            return PREFIX + text;
        }
    }

    public enum View {
        NOT_NUMBER("숫자만 입력가능합니다."),
        CAN_NOT_OVERRIDE("지정한 값은 변경할 수 없습니다"),
        WRONG_INPUT("잘못된 값 입력입니다.");
        private final String text;

        View(String text) {
            this.text = text;
        }

        public String getText() {
            return PREFIX + text;
        }
    }
}
