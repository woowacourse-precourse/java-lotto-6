package lotto.constant;

public enum ErrorMessage {

    NUMBER("숫자를 입력해주세요.")
    ,DIVIDE("1000으로 나누어 떨어져야 합니다.")
    ,ZERO("한 개 이상의 복권을 사야됩니다.")
    ,BONUSNUMBERDUPLICATE("보너스 번호가 당첨 번호와 중복됩니다.")
    ,NUMBERINRANGE("번호는 1이상 45이하의 숫자입니다.")
    ,NUMBERDUPLICATE("중복된 숫자가 있으면 안됩니다.")
    ,NUMBERSIZE("숫자 6개를 입력해주세요.");


    private static final String ERROR = "[ERROR]";
    private final String error_message;

    ErrorMessage(String error_message) {
        this.error_message = error_message;
    }

    public String getMessage() {
        return ERROR + " " + error_message;
    }
}
