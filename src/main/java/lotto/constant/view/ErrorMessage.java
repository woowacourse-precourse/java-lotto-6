package lotto.constant.view;

public enum ErrorMessage {
    PURCHASE_TYPE("[ERROR] 구매금액은 숫자로만 이루어져야 합니다."),
    PURCHASE_REMINDER("[ERROR] 구매금액은 천원 단위로 입력합니다."),
    WINNING_COUNT("[ERROR] 당첨 번호는 6개를 입력해야 합니다."),
    NOT_BLANK("[ERROR] 로또 번호를 입력해 주세요."),
    NUMBER_DUPLICATE("[ERROR] 로또 번호는 중복될 수 없습니다."),
    ENTER_NUMBER("[ERROR] 입력은 숫자여야 합니다."),
    BONUS_COUNT("[ERROR] 보너스 번호는 1개를 입력해야 합니다."),
    NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이어야 합니다."),
    ENTER_COMMA("[ERROR] 쉼표가 입력되어야 합니다."),
    BONUS_DUPLICATE("[ERROR] 보너스 번호와 당첨 번호는 중복 될 수 없습니다.");



    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
