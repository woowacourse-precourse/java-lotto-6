package lotto.error;

public enum LottoErrorMessage {
    LOTTO_NUMBER_OUT_OF_RANGE("로또 범위 이외의 숫자가 생성되었습니다. 1 부터 45 숫자를 입력해주세요."),
    WRONG_LOTTO_PRICE("잘못된 복권 구입 금액을 입력하셨습니다. 복권 가격(1,000원) 단위로 다시 입력해 주세요."),
    WRONG_LOTTO_NUMBER("잘못된 로또 번호를 입력하셨습니다. 1 부터 45 숫자를 입력해주세요."),
    NOT_ENOUGH_MONEY("복권 가격(1,000원) 보다 적은 금액을 입력하셨습니다. 다시 입력해 주세요."),
    PRICE_DOES_NOT_ZERO("복권 가격은 0이 될 수 없습니다 0 이상의 수로 설정해주세요."),
    BUYING_PRICE_MUST_PRICE_UNIT("복권의 구입 가격은 복권 가격(1,000원)단위로 입력하셔야 합니다."),
    DUPLICATED_LOTTO_NUMBERS("로또 번호 중 중복된 번호가 존재합니다."),
    ALREADY_WINNING_NUMBER("이미 당첨번호에 포함되어 있는 번호입니다. 다른 번호를 입력해주세요."),
    INVALID_LOTTO_SIZE("로또 번호개수가 잘못되었습니다. 다시 입력해 주세요.");

    private String message;

    private LottoErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
