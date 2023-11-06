package lotto.constants;

import static lotto.constants.LottoConstants.*;

public class ErrorMessageConstants {
    public static final String INVALID_WINNING_NUMBERS_SIZE = ",로 구분하여 총 "+LOTTO_NUMBER_COUNT+"개의 숫자를 입력해주세요";
    public static final String NOT_INTEGER_NUMBER = "정수만 입력이 가능합니다.";
    public static final String NUMBER_OUT_OF_RANGE = LOTTO_NUMBER_MIN+"~"+LOTTO_NUMBER_MAX+" 범위의 정수만 입력 가능합니다.";
    public static final String DUPLICATE_NUMBERS = "중복된 값이 존재합니다.";
    public static final String MINIMUM_PURCHASE_AMOUNT = "최소 구매 금액은 "+ LOTTO_PRICE+"원 입니다.";
    public static final String NOT_DIVISION_BY_LOTTO_PRICE = LOTTO_PRICE+"원 단위로만 입력이 가능합니다.";
    public static final String BONUS_NUMBER_INCLUDED = "보너스 번호가 당첨 번호에 포함되어 있습니다.";
    public static final String NO_MATCHING_RANK = "맞힌 개수와 일치하는 Rank가 없습니다";
}
