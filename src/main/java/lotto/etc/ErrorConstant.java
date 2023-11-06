package lotto.etc;

public enum ErrorConstant {

    NOT_SIX_ERROR("[ERROR] 주어진 숫자가 6개가 아닙니다. 다시 입력하세요."),
    DUPLICATE_ERROR("[ERROR] 중복된 수가 있습니다. 다시 입력하세요."),
    BETWEEN_ONE_AND_FORTY_FIVE_ERROR("[ERROR] 1-45 사이의 숫자가 아닙니다. 다시 입력하세요."),
    BONUS_ERROR("[ERROR] 보너스 수가 입력 수와 중복됩니다. 다시 입력하세요."),
    NOT_NUMBER_ERROR("[ERROR] 숫자가 아닌 값이 들어왔습니다. 다시 입력하세요."),
    LOW_THOUSAND_ERROR("[ERROR] 입력된 숫자가 1,000보다 작습니다. 다시 입력하세요"),
    NOT_DIVIDE_THOUSAND_ERROR("[ERROR] 들어온 숫자가 천의 자리로 나누어 떨어지지 않습니다. 다시 입력하세요");

    private String enumString;
    ErrorConstant(String enumStr) {
        enumString = enumStr;
    }
    @Override
    public String toString(){
        return enumString;
    }

}
