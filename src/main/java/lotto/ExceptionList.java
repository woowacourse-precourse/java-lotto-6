package lotto;

public enum ExceptionList {
    LOTTOCOUNTEXCETION("[ERROR] 당첨 로또는 6개의 정수여야 합니다."),
    LOTTORANGEEXCEPTION("[ERROR] 당첨 로또는 1에서 45 사이 정수여야 합니다."),
    BONUSLOTTORANGEEXCEPTION("[ERROR] 보너스 로또는 1에서 45 사이 정수여야 합니다."),
    LOTTODUPLICATIONEXCEPTION("[ERROR] 당첨 로또는 중복되지 않은 수여야 합니다."),
    BONUSLOTTODUPLICATIONEXCEPTION("[ERROR] 보너스 로또는 중복되지 않은 수여야 합니다."),
    MONEYUNITEXCEPTION("[ERROR] 구입 금액은 1000원 단위로 이루어져야 합니다."),
    MONEYEXCEPTION("[ERROR] 구입 금액은 정수로만 이루어져야 합니다."),
    LOTTOEXCEPTION("[ERROR] 당첨 로또는 정수여야 합니다."),
    BONUSLOTTOEXCETPION("[ERROR] 보너스 로또는 정수여야 합니다.");

    private final String content;

    ExceptionList(String content) {
        this.content = content;
    }

    public String content() {
        return content;
    }
}
