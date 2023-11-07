package lotto.constant;

public enum Message {
    OUTPUTLOTTOAMOUNTOFMONEY("구입금액을 입력해 주세요."),
    OUTPUTANSWERNUMBER("당첨 번호를 입력해 주세요."),
    OUTPUTBONUSNUMBER("보너스 번호를 입력해 주세요."),
    OUTPUTBUYINGMESSAGE("%d개를 구매했습니다.\n"),
    OUTPUTFIFTHRANK("3개 일치 (5,000원) - %s개\n"),
    OUTPUTFOURTHRANK("4개 일치 (50,000원) - %s개\n"),
    OUTPUTTHIRDRANK("5개 일치 (1,500,000원) - %s개\n"),
    OUTPUTSECONDRANK("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개\n"),
    OUTPUTFIRSTRANK("6개 일치 (2,000,000,000원) - %s개\n"),
    OUTPUTWINNINGREWARDRATE("총 수익률은 %s%c입니다."),
    OUTPUTWINNINGSTATIC("당첨 통계\n---"),
    ;

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
