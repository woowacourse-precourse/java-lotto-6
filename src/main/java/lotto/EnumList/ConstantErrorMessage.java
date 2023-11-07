package lotto.EnumList;

public enum ConstantErrorMessage {
    ERROR_LOTTO_NUMBER_SIZE("[ERROR] 로또 번호 갯수가 6개가 아닙니다."),
    ERROR_LOTTO_NUMBER_DUPLICATE("[ERROR] 중복된 숫자가 발생했습니다."),
    ERROR_NUMBER("[ERROR] 숫자를 입력하세요."),
    ERROR_INSERT_WON("[ERROR] 1,000원 단위로 입력하세요."),
    ERROR_NUMBER_SIZE_MESSAGE("[ERROR] 1부터 45 사이의 숫자를 입력하세요.");

    private final String message;

    ConstantErrorMessage(String message) {
        this.message = message;
    }

    public String errorMessage() {
        return message;
    }
}
