package lotto.message;

public enum ErrorMessage {
    NOT_NUMBER_ERROR("[ERROR] 숫자를 입력해주세요."),
    IS_EMPTY_REGISTRY_ERROR("[ERROR] 응답이 존재하지 않습니다. 질문에 맞는 대답을 입력해주세요."),
    HAS_SPACE_ERROR("[ERROR] 글자에 공백이 포함되지 않도록 다시 입력해주세요."),
    INVALID_AMOUNT_ERROR("[ERROR] 로또는 1개 이상 구입해야하며, 1000원 단위로만 구매가 가능합니다. 1000원의 배수를 입력해주세요."),
    INVALID_LOTTO_SIZE_ERROR("[ERROR] 1~45사이의 숫자 6개를 입력해주세요."),
    SAME_NUMBER_ERROR("[ERROR] 1~45 사이의 서로 다른 숫자 6개를 입력해주세요."),
    INVALID_LOTTO_NUMBER_ERROR("[ERROR] 로또 번호의 숫자 범위는 1~45입니다.");


    private String message;
    ErrorMessage (String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}