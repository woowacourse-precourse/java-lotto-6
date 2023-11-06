package lotto.util.error;

public enum CustomError {
    INPUT_RANGE_ERROR("입력 범위는 1부터 35까지입니다."),
    INPUT_IS_NOT_NUMBER("입력된 값이 숫자가 아닙니다."),
    INPUT_CONTAIN_BLANK("입력에 빈칸이 포함되어 있습니다.")
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
