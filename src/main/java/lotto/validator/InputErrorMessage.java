package lotto.validator;

public enum InputErrorMessage {
    MAX_INPUT_VALUE_ERROR("[ERROR] 구매할 수 있는 금액은 최대 20억원입니다."),
    INPUT_VALUE_INTEGER_ERROR("[ERROR] 정수 값을 입력해 주세요."),
    INPUT_DIVIDE_ERROR("[ERROR] 구입 금액은 1,000으로 나누어 떨어지는 0이상의 값이어야 합니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR("[ERROR] 로또번호는 중복되는 수가 없어야 합니다."),
    LOTTO_NUMBER_IS_INTEGER("[ERROR] 로또번호는 쉼표를 기준으로 구분된 정수값이어야합니다."),
    LOTTO_NUMBER_RANGE_ERROR("[ERROR] 로또 번호는 1이상 45이하의 정수여야 합니다."),
    LOTTO_NUMBER_INPUT_ERROR("[ERROR] 로또 번호는 쉼표를 기준으로 나뉘어 6개 입력받아야 합니다."),
    LOTTO_BONUS_NUMBER_DUPLICATE_ERROR("[ERROR] 보너스 번호는 기존 로또번호와 중복되지 않아야 합니다.");

    private final String message;

    InputErrorMessage(String message){
        this.message=message;
    }

    public String getMessage(){
        return message;
    }


}
