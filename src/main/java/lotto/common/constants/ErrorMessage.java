package lotto.common.constants;

public enum ErrorMessage {
    ERROR_BLANK("[ERROR] 아무것도 입력하지 않았습니다."),
    ERROR_NOT_NUMBER("[ERROR] 숫자만 입력할 수 있습니다."),
    ERROR_UNDER_THOUSAND("[ERROR] 구입 금액은 " + LottoRule.ONE_LOTTO_TICKET_PRICE.getRule() + Unit.KOREA_MONEY.getUnit() + " 이상이어야 합니다."),
    ERROR_NOT_THOUSAND_UNITS("[ERROR] 구입 금액은 " + LottoRule.ONE_LOTTO_TICKET_PRICE.getRule() + Unit.KOREA_MONEY.getUnit() + " 단위만 허용합니다."),
    ERROR_NOT_LOTTO_RANGE("[ERROR] 로또 번호는 " + LottoRule.PICK_MIN_NUMBER.getRule() + "부터 "  + LottoRule.PICK_MAX_NUMBER.getRule() +  " 사이의 숫자여야 합니다."),
    ERROR_NOT_SIX_LOTTO_NUMBER("[ERROR] 로또 번호는 " + LottoRule.PICK_HIT_NUMBER_TOTAL.getRule() + "개의 숫자를 입력해야 합니다."),
    ERROR_OVERLAP_LOTTO_NUMBER("[ERROR] 로또 번호는 중복된 숫자를 입력할 수 없습니다."),
    ERROR_OVERLAP_BONUS_LOTTO_NUMBER("[ERROR] 보너스 번호는 이전에 입력한 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
