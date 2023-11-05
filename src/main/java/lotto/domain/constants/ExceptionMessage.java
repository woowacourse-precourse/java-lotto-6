package lotto.domain.constants;

public enum ExceptionMessage {
    HEADER("[ERROR] "),
    ONLY_NUMBER_REGEX("\\d+"),
    NOT_NUMBER("숫자만 입력해 주십시오."),
    INPUT_MONEY_NOT_THOUSAND_UNIT("구입 금액은 1,000원 단위로 입력해 주십시오."),
    NUMBER_OUT_OF_RANGE(LottoSetting.LOTTO_NUMBER_RANGE_START.getNumber() + " ~ " +
            LottoSetting.LOTTO_NUMBER_RANGE_END.getNumber() + " 사이의 숫자를 입력해 주십시오."),
    WINNING_NUMBERS_COUNT_OUT_OF_RANGE("당첨 번호는 " +
            LottoSetting.LOTTO_WINNING_NUMBERS_COUNT.getNumber() + "개를 입력해 주십시오."),
    WINNING_NUMBERS_DUPLICATION("당첨 번호는 중복될 수 없습니다."),
    BONUS_NUMBER_DUPLICATION_WITH_WINNING_NUMBERS("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    }
