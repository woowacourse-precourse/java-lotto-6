package lotto.enums;

public enum Error {
    INPUT_ERROR("[ERROR] 입력 값을 확인해주세요.\n");

    private final String errMsg;

    Error(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrMsg(){
        return errMsg;
    }
}
