package lotto.view;

public enum InputMessage {

    INPUT_MONEY("구입금액을 입력해 주세요.");


    final String msg;
    InputMessage(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return this.msg;
    }
}
