package lotto.constant;

import static lotto.constant.Number.LOTTO_MAX_NUM;
import static lotto.constant.Number.LOTTO_NUM_COUNT;
import static lotto.constant.Number.LOTTO_PRICE;

public enum ExceptionMessage {

    REQUIRE_NONEMPTY_INPUT("값을 입력해주세요."),
    REQUIRE_POSITIVE_LONG("9,223,372,036,854,775,807 이하의 양의 정수여야 합니다."),
    REQUIRE_POSITIVE_INTEGER("2,147,483,647 이하의 양의 정수여야 합니다."),
    REQUIRE_MULTIPLE_OF_LOTTO_PRICE(
            String.format("구입 금액은 %s으로 나누어 떨어져야 합니다.", LOTTO_PRICE.getNumber())),
    REQUIRE_NOT_STARTS_WITH_COMMA("입력은 ,로 시작하지 않아야 합니다."),
    REQUIRE_NOT_ENDS_WITH_COMMA("입력은 ,로 끝나지 않아야 합니다."),
    REQUIRE_SIX_NUMBERS(String.format("숫자 개수는 %s개여야 합니다.", LOTTO_NUM_COUNT.getNumber())),
    REQUIRE_RIGHT_RANGE_NUMBER(String.format("%s~%s 사이의 정수를 입력해야 합니다.", Number.LOTTO_MIN_NUM.getNumber(),
            LOTTO_MAX_NUM.getNumber())),
    REQUIRE_UNIQUE_NUMBERS("중복되지 않은 값을 입력해야 합니다."),
    REQUIRE_DIFFERENT_NUMBER_WITH_WINNING_NUMBERS("당첨번호와 중복되지 않은 값을 입력해주세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        String error = "[ERROR] ";
        return error + message;
    }
}
