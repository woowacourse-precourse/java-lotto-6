package lotto;

public enum Text {
    START("구입금액을 입력해 주세요."),
    SHOW("개를 구매했습니다."),
    INPUTNUMBER("당첨 번호를 입력해 주세요."),
    INPUTBONUS("보너스 번호를 입력해 주세요."),
    SHOWRESULT("당첨통계"),
    DIVIDER("---"),
    RATE1("총 수익률은 "),
    RATE2("%입니다.");

    private final String text;
    Text(String text){this.text = text;}
    public String getText(){return text;}

    @Override
    public String toString() {
        return getText();
    }
}
