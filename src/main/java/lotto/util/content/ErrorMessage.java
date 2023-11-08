package lotto.util.content;

public enum ErrorMessage {

    ERROR_WORD("[ERROR] "),
    LOTTO_SIZE_ERROR("로또 번호가 6개의 숫자로 이뤄지지 않았습니다."),
    LOTTO_RANGE_ERROR("로또 번호는 1 ~ 45 사이의 숫자이어야만 합니다."),
    INPUT_UNIT_ERROR("로또 구입 비용은 1,000원 단위로 입력해야 합니다."),
    INPUT_SPACE_ERROR("공백을 허용하지 않습니다."),
    INPUT_NUMERIC_ERROR("정수형 숫자를 입력해야 합니다."),
    INPUT_COMMA_ERROR("입력 형식이 올바르지 않습니다. 입력은 공백 없이 쉼표(,)로 구분 해주세요."),
    UNIQUE_NUMBER_ERROR("중복된 숫자가 있습니다. 확인 후 다시 시도 해주세요."),
    UNIQUE_BONUS_ERROR("보너스 번호는 당첨 번호와 중복되어서는 안됩니다. 확인 후 다시 시도 해주세요.");

    private final String content;

    ErrorMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
