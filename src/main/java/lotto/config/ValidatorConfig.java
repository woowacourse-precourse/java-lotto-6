package lotto.config;

public enum ValidatorConfig {

    PURCHASE_UNIT_ERROR("[ERROR] 입력하신 금액은 1,000원 단위가 아닙니다."),
    STRING_TO_INTEGER_ERROR("[ERROR] 입력 값은 숫자로만 이루어져 있어야 합니다."),
    NUMBER_RANGE_ERROR("[ERROR] 로또 번호는 1 ~ 45 범위내에 존재해야 합니다."),
    DUPLICATE_NUMBER_ERROR("[ERROR] 중복된 숫자가 존재하면 안됩니다."),
    COMMA_ERROR("[ERROR] 쉼표 기준으로 구분해야 합니다."),
    NUMBER_LENGTH_ERROR("[ERROR] 로또 번호는 6개로 이루어져야 합니다."),
    DUPLICATED_NUMBER_IN_LIST_ERROR("[ERROR] 보너스 번호는 로또 번호와 중복이 불가합니다.");

    private final String message;

    ValidatorConfig(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
