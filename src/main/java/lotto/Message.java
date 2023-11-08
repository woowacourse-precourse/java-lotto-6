package lotto;

public enum Message {
    INPUT_COST("구입금액을 입력해 주세요."),
    INPUT_TARGET("당첨 번호를 입력해 주세요."),
    INPUT_BONUS("보너스 번호를 입력해 주세요."),
    INPUT_NUMBER("[ERROR] 숫자를 입력하세요."),
    INPUT_SIX_NUMBERS("[ERROR] 6개의 숫자를 입력하세요."),
    INPUT_NUMBER_NEGATIVE("[ERROR] 금액은 음수일 수 없습니다."),
    INPUT_NUMBER_THOUSAND("[ERROR] 금액은 천 단위의 수여야 합니다."),
    INPUT_NUMBER_BETWEEN("[ERROR] 1 이상 45 이하의 숫자를 입력하세요."),
    INPUT_BONUS_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INPUT_DUPLICATE("[ERROR] 당첨번호는 중복될 수 없습니다."),
    MSG_STATISTICS("당첨 통계\n---"),
    MSG_RATE_FRONT("총 수익률은 "),
    MSG_RATE_BACK("%입니다."),
    MSG_TICKET("개를 구매했습니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
