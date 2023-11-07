package lotto.view;

public enum RequestLine {

    requestAmount("구입금액을 입력해 주세요."),
    resultBuy("\n%d개를 구매했습니다.\n"),
    requestLotto("\n당첨 번호를 입력해 주세요."),
    requestBonus("\n보너스 번호를 입력해 주세요."),
    resultStats("\n당첨 통계"),
    hyphen("---"),
    resultRate("총 수익률은 %s%%입니다.");

    private final String line;

    RequestLine(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }
}
