package lotto.constants;

public enum ValidatorConstants {
    INPUT_IS_NOT_PRIME_NUMBER("[ERROR] 입력이 정수가 아닙니다."),
    INPUT_IS_NOT_POSITIVE_NUMBER("[ERROR] 입력이 양의 정수가 아닙니다."),
    INPUT_IS_NOT_IN_UNITS_OF_LOTTO_PRICE("[ERROR] 입력이 %d원 단위가 아닙니다."),
    WINNING_NUMBER_FORM_IS_WRONG("[ERROR] 당첨 번호의 형식이 잘 못 됐습니다."),
    LOTTO_INPUT_SHOULD_BE_N("[ERROR] 복권 번호는 %d개 입력해야합니다."),
    SHOULD_NOT_DUPLICATE("[ERROR] 복권 번호는 중복되면 안됩니다."),
    SHOULD_BE_IN_LOTTO_NUMBER_RANGE("[ERROR] 복권 번호는 %d이상 %d이하이어야 합니다");

    private final String value;

    ValidatorConstants(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
