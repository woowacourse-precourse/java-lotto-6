package lotto.util.error;

public enum CustomError {
    INPUT_IS_NOT_NUMBER("입력된 값이 숫자가 아닙니다."),
    INPUT_CONTAIN_BLANK("입력에 빈칸이 포함되어 있습니다."),
    INPUT_IS_NOT_THOUSAND("1000원 단위로 입력하세요."),
    INPUT_MAX_NUMBER("숫자 6개를 입력하세요."),
    INPUT_NUMBER_RANGE("숫자의 입력 범위는 1부터 45까지입니다."),
    NUMBER_DUPLICATE("중복된 숫자가 있습니다.")
    ;

    private final String description;

    private CustomError(String description){
        this.description = description;
    }
    public String getError(){
        String prefix = "[ERROR] ";
        return prefix +description;
    }
}
