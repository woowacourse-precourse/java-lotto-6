package lotto.model;

enum Valid {
    COUNT_BOUNDARY( "숫자를 6개만 입력해주세요."),
    NUM_BOUNDARY("1~45 사이의 숫자만 입력해주세요"),
    NUM_REPLICA("숫자가 중복되지 않게 해주세요."),
    MONEY_UNIT("1,000원 단위로 입력해주세요.");

    private String errorMessage;

    private Valid(String message){
        this.errorMessage = "[ERROR]" + message;
    }
    public String getErrorMessage(){
        return errorMessage;
    }

}
