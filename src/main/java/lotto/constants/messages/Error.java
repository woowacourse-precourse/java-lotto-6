package lotto.constants.messages;

import lotto.constants.LottoStatus;

public final class Error {
    private static final String ERROR_MESSAGE = "[ERROR]";
    public static final String NO_EMPTY = String.format("%s 값을 입력해주세요(입력 없음).", ERROR_MESSAGE);
    public static final String NO_EMPTY_BETWEEN_NUMBERS = String.format(
            "%s 쉼표 사이에 숫자를 입력해주세요(입력 누락).", ERROR_MESSAGE);
    public static final String NOT_NUMBER = String.format(
            "%s 숫자를 입력해주세요(문자, 공백 금지).", ERROR_MESSAGE);
    public static final String NOT_JUST_NUMBERS = String.format(
            "%s 숫자를 입력해주세요(쉼표 사이에 문자, 공백 금지).", ERROR_MESSAGE);
    public static final String NOT_ENOUGH_MONEY = String.format(
            "%s 입력 금액이 부족합니다(판매가: %d원).", ERROR_MESSAGE, LottoStatus.PRICE
    );
    public static final String NO_CHANGE = String.format(
            "%s 입력 금액은 %d으로 나누어 떨어져야 합니다(잔돈 없음).", ERROR_MESSAGE, LottoStatus.PRICE
    );
    public static final String NOT_SIX_BALLS = String.format(
            "%s 로또 번호는 %d개여야 합니다.", ERROR_MESSAGE, LottoStatus.SIZE
    );
    public static final String DUPLICATE_NUMBERS = String.format(
            "%s 로또 번호는 중복되지 않아야 합니다.", ERROR_MESSAGE);
    public static final String OUT_OF_RANGE = String.format(
            "%s 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", ERROR_MESSAGE, LottoStatus.MIN_VALUE, LottoStatus.MAX_VALUE
    );
}
