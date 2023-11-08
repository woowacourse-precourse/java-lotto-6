package lotto.io;

public enum LottoMessage {

    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요.");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
