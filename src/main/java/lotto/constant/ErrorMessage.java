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
}
