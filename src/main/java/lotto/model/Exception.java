package lotto.model;

public enum Exception {
    NON_NUMERIC_LOTTO_NUMBERS_ERROR("[ERROR] 로또 번호에 숫자가 아닌 값이 들어왔습니다."),
    LOTTO_NUMBER_COUNT_ERROR("[ERROR] "
            + LottoGameSettingConstValue.LOTTO_NUMBER_SIZE.getValue()
            + "개의 로또번호를 입력해주세요"),
    DUPLICATED_LOTTO_NUMBER_ERROR("[ERROR] 로또 번호는 중복된 숫자를 가질 수 없습니다"),
    OUT_OF_RANGE_LOTTO_NUMBER_ERROR("[ERROR] 로또 번호를 지정된 범위안의 숫자로 넣어주세요. 범위 "
            + LottoGameSettingConstValue.MIN_LOTTO_NUMBER.getValue()
            + "~"
            + LottoGameSettingConstValue.MAX_LOTTO_NUMBER.getValue()),
    NON_NUMERIC_MONEY_ERROR("[ERROR] 구입 금액에 숫자가 아닌 값이 들어왔습니다."),
    OUT_OF_RANGE_MONEY_ERROR("[ERROR] 구입 금액에 값을 1000원 단위로 넣어주세요, 최대구입금액 "
            + LottoGameSettingConstValue.MAXIMUM_PURCHASE_AMOUNT.getValue()
            + "원."),
    OUT_OF_RANGE_BONUS_MONEY_ERROR("[ERROR] 보너스 번호를 지정된 범위안의 숫자로 넣어주세요. 범위 "
            + LottoGameSettingConstValue.MIN_LOTTO_NUMBER.getValue()
            + "~"
            + LottoGameSettingConstValue.MAX_LOTTO_NUMBER.getValue()),
    NON_NUMERIC_BONUS_NUMBERS_ERROR("[Error] 보너스 번호에 숫자가 아닌 값이 들어왔습니다."),
    LOTTO_NUMBERS_CONTAIN_BONUS_NUMBER_ERROR("[ERROR] 보너스 번호는 로또 번호와 겹치면 안됩니다.");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
