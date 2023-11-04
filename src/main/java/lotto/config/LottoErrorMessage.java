package lotto.config;

public enum LottoErrorMessage {
    INCORRECT_LOTTO("로또 숫자가 6개가 아닙니다."),
    DUPLICATED_NUM("로또 번호로 중복된 숫자가 생성되었습니다."),
    INCORRECT_SIZE("구매한 로또와 생성된 로또의 숫자가 다릅니다.");

    private final String message;

    LottoErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
