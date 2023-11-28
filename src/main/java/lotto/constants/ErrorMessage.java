package lotto.constants;

public enum ErrorMessage {
    DUPLICATION("[ERROR] 값이 중복되었습니다"),
    ISNOTINTEGER("[ERROR] 숫자를 입력해주세요"),
    SIXNUMBER("[ERROR] 번호 6개를 입력해주세요"),
    OUTFRANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ONENUMBER("[ERROR] 숫자 번호 1개를 입력해주세요");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
