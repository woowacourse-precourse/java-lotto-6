package lotto.constants;

public enum ValidatorConstants {
    INPUT_IS_NOT_PRIME_NUMBER("[ERROR] 입력이 정수가 아닙니다."),
    INPUT_IS_NOT_POSITIVE_NUMBER("[ERROR] 입력이 양의 정수가 아닙니다."),
    INPUT_IS_NOT_IN_UNITS_OF_LOTTO_PRICE("[ERROR] 입력이 %d단위가 아닙니다.");

    private final String value;

    ValidatorConstants(String value){
        this.value = value;

    }

    public String getValue(){
        return value;
    }
}
