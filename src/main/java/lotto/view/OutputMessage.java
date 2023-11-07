package lotto.view;

public enum OutputMessage {
    BOUGHT_OUTPUT("개를 구매했습니다.");

    private final String msg;
    OutputMessage(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return this.msg;
    }
}
