package lotto;

public enum ErrorMessage {
    BOUND_LENGTH("[ERROR] 로또 번호는 6개가 필요합니다."),
    NON_PROPER_NUMS("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NON_DUPLICATED_NUMS("[ERROR] 로또 번호는 중복되면 안됩니다.");
    String errorMessage;
    ErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage(){
        return errorMessage;
    }
}
