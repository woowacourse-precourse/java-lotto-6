package lotto;

public enum Progress {
    PURCHASE("구입금액을 입력해 주세요."),
    BUY("개를 구매했습니다."),
    WINNING("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요."),
    STATISTIC("당첨 통계"),
    FIFTH("3개 일치 (5,000원) - "),
    FOURTH("4개 일치 (50,000원) - "),
    THIRD("5개 일치 (1,500,000원) - "),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST("6개 일치 (2,000,000,000원) - ");

    private String message;

    Progress(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
