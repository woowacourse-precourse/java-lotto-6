package lotto.constant;

import static lotto.constant.LottoInfo.LOTTO_PRICE;

public class ErrorMessage {
    // 문자열 처리
    public static final String INPUT_EMPTY = "입력하신 문자열은 빈 문자열입니다.";
    public static final String INPUT_CONTAINS_WHITE_SPACE = "입력하신 문자열에 공백이 포함되어 있습니다.";
    public static final String INPUT_IS_NOT_INTEGER = "입력하신 문자열은 정수가 아닙니다.";

    // 로또 구매 금액 입력
    public static final String INPUT_PRICE_IS_NOT_MULTIPLE_OF_LOTTO_PRICE = "로또 구매 가격은 " + LOTTO_PRICE + "원 단위로 입력해 주세요.";
    public static final String INPUT_PRICE_IS_NOT_GREATER_THAN_ZERO = "로또 구매 가격은 음수가 될 수 없습니다.";

    // 로또 번호
    public static final String LOTTO_NUMBER_WRONG_COUNT = "로또 번호는 6개여야 합니다.";
    public static final String LOTTO_NUMBER_DUPLICATED = "로또 번호는 중복될 수 없습니다.";
    public static final String LOTTO_NUMBER_OUT_OF_RANGE = "로또 번호는 1~45 이내의 숫자여야 합니다.";

    // 로또 당첨 번호 입력
    public static final String INPUT_WINNING_NUMBER_COUNT_IS_INCORRECT = "당첨 번호는 6개를 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER_VALUE_OUT_OF_RANGE = "당첨 번호 값은 1 ~ 45 사이의 값을 입력해 주세요.";
}
