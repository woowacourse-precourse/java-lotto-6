package lotto.view;

public enum OutputMessage {
    BOUGHT_OUTPUT("개를 구매했습니다."),
    STATISTIC_OUTPUT("당첨 통계\n" + "---");

    private final String msg;
    OutputMessage(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return this.msg;
    }
}
