package lotto.view;

public enum ErrorMessage {
    VALUE_ERROR("1,000 단위로 입력해주세요."),
    INPUT_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATION_ERROR("중복되지 않은 값을 입력해야 합니다.");

    private final String msg;
    ErrorMessage(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return "[ERROR]" + this.msg;
    }
}
