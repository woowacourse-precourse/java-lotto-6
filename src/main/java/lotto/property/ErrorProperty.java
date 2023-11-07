package lotto.property;

import static lotto.property.LottoProperty.COST_UNIT_STANDARD;
import static lotto.property.LottoProperty.WINNING_SIZE;

public enum ErrorProperty {
    VALUE_IS_EMPTY("입력 값이 공백입니다"),
    VALUE_CONTATIN_SPACE("입력 값에 공백이 포함되어있습니다."),
    VALUE_IS_NOT_NUMERIC("입력 값은 숫자외의 값을 허용하지 않습니다."),
    NUMBER_IS_NOT_CORRECTLY_RANGE("당첨번호와 보너스번호는 1 ~ 45 사이의 숫자여야합니다."),
    WINNING_COUNT_IS_OVER_OR_UNDER("당첨번호의 개수는 %s개 이어야합니다.".formatted(WINNING_SIZE)),
    WINNING_FORMAT_IS_NOT_CORRECT("당첨번호의 입력 양식이 옳바르지 못합니다."),
    COST_FORMAT_IS_NOT_CORRECT("구입금액은 %s 단위로 구매해야합니다.".formatted(COST_UNIT_STANDARD)),
    COST_IS_STANDARD_UNDER("구입금액은 최소 %s 입니다.".formatted(COST_UNIT_STANDARD)),
    FILED_MAPPER_IS_NOT_CORRECT_PARAMETER("Getter 사용시 잘못된 값이 포함되었습니다."),
    LOTTO_SIZE_IS_NOT_STANDARD("로또의 개수는 %s개 이어야합니다.".formatted(WINNING_SIZE)),
    LOTTO_RESULT_GENERATE_ERROR("로또 결과 생성중 에러가 발생하였습니다.");

    private String errorMessage;

    ErrorProperty(String errorMessage) {
        this.errorMessage = errorPrefix + errorMessage;
    }

    static final String errorPrefix = "[ERROR] ";

    @Override
    public String toString() {
        return errorMessage;
    }
}
