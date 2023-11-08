package util;

public enum ValidationBonusNumberMessages {

    NOT_A_NUMBER("[ERROR] 숫자만 입력해주세요.");

    private String message;

    private ValidationBonusNumberMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
