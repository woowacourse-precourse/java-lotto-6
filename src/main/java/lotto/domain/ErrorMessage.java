package lotto.domain;

public enum ErrorMessage {

    SIZE("로또 번호는 6글자만 가능합니다."),
    DUPLICATE("중복되는 숫자가 존재합니다."),
    TYPE_INT("숫자만 입력해주세요."),
    PRICE_REMAIN("천 단위로 입력해주세요."),
    LOTTO_RANGE("범위는 1 ~ 45로 해주세요.")
    ;

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String BLANK = " ";
    private final String description;

    ErrorMessage(String description) {
        this.description = description;
    }

    public static void getDescription(ErrorMessage errorMessage) {
        System.out.println(ERROR_MESSAGE + BLANK + errorMessage.description);
    }
}
