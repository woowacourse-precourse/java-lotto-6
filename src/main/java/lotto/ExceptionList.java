package lotto;

public enum ExceptionList {
    LOTTOCOUNTEXCETION("[ERROR] 당첨 로또는 6개의 정수여야 합니다.\n"),
    LOTTORANGEEXCEPTION("[ERROR] 당첨 로또는 1에서 45 사이 정수여야 합니다.\n"),
    BONUSLOTTORANGEEXCEPTION("[ERROR] 보너스 로또는 1에서 45 사이 정수여야 합니다.\n"),
    LOTTODUPLICATIONEXCEPTION("[ERROR] 당첨 로또는 중복되지 않은 수여야 합니다.\n"),
    BONUSLOTTODUPLICATIONEXCEPTION("[ERROR] 보너스 로또는 중복되지 않은 수여야 합니다.\n"),
    MONEYUNITEXCEPTION("[ERROR] 구입 금액은 1000원 단위로 이루어져야 합니다.\n"),
    MONEYEXCEPTION("[ERROR] 구입 금액은 정수로만 이루어져야 합니다.\n"),
    LOTTOEXCEPTION("[ERROR] 당첨 로또는 정수여야 합니다.\n"),
    BONUSLOTTOEXCETPION("[ERROR] 보너스 로또는 정수여야 합니다.\n");

    private final String content;

    ExceptionList(String content) {
        this.content = content;
    }

    public String content() {
        return content;
    }
}
