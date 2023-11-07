package lotto.exception;

public enum ExceptionMessage {
    WRONG_LOTTO_SIZE("6개의 숫자를 입력하지 않았습니다.", ModifyingType.LOTTO_NUMBER),
    DUPLICATED_NUMBER("중복된 숫자를 입력했습니다.", ModifyingType.LOTTO_NUMBER),
    OUT_OF_RANGE_LOTTO_NUMBER("범위에서 벗어난 수를 입력했습니다. 로또 번호 범위는 1~45까지입니다",
            ModifyingType.LOTTO_NUMBER),
    NOT_MATCHES_LOTTO_PATTERN("로또 번호는 (,) 로 구분해서 입력해야 합니다.", ModifyingType.LOTTO_NUMBER),

    SAME_NUMBER_WITH_LOTTO_NUMBER("로또 번호와 중복된 보너스 번호입니다.", ModifyingType.BONUS_NUMBER),
    OUT_OF_RANGE_BONUS_NUMBER("범위에서 벗어난 수를 입력했습니다. 보너스 번호 범위는 1~45까지입니다.",
            ModifyingType.BONUS_NUMBER),

    NULL_INPUT("아무것도 입력하지 않았습니다.", ModifyingType.EVERY_NUMBER),
    NOT_MATCHES_NUMBER_PATTERN("숫자를 입력하지 않았습니다.", ModifyingType.EVERY_NUMBER),
    MULTIPLE_LETTERS_STARTS_WITH_ZERO("0으로 시작하는 수는 0만 가능합니다.", ModifyingType.EVERY_NUMBER),

    NOT_UNIT("1000 단위의 금액을 입력해주세요", ModifyingType.MONEY_NUMBER)
    ;

    private static final String PREFIX = "[ERROR] ";
    private final String errorDescription;
    private final ModifyingType modifyingType;

    ExceptionMessage(String errorDescription, ModifyingType modifyingType) {
        this.errorDescription = errorDescription;
        this.modifyingType = modifyingType;
    }

    public String getErrorDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PREFIX);
        stringBuilder.append(errorDescription);
        stringBuilder.append(modifyingType.getModifyingMessage());
        return stringBuilder.toString();
    }
}
