package ErrorMessages;

public enum CustomErrorMessages {
    UNMATCHED_WITH_INPUT_FORM("[ERROR] 입력 형식과 맞지 않는 입력입니다."),
    CANNOT_DIVIDED_WITH_1000("[ERROR] 구입가격은 1000원 단위여야 합니다."),
    DUPLICATED_BONUS_NUMBER("[ERROR] 입력한 보너스 숫자는 이미 당첨 번호 리스트에 있습니다."),
    OUT_OF_VALID_NUMBER_RANGE("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");

    private String msg;

    CustomErrorMessages(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
