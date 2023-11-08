package lotto.enums;

public enum LottoException {
    INVALID_BUYING_PRICE("구입금액은 1000의 배수인 숫자로 입력해 주세요");

    private final String prompt;

    LottoException(String prompt) {
        this.prompt = prompt;
    }


    public String getPrompt(){
        return this.prompt;
    }
}
