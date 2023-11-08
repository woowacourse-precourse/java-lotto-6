package util;

public enum InputException {
    RANGE_OF_NUMBER_EXCEPTION("[ERROR] 숫자의 범위는 1부터 45 사이입니다."),
    LENGTH_NUMBEr_ERROR("[ERROR] 숫자의 갯수는 8개 입니다.");

    String errorMessage;
    InputException(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getMessage(){
        return errorMessage;
    }
}
