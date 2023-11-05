package lotto.constant;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum ErrorMessage {
    BLANK_VALUE(000, "값을 입력해 주세요."),
    NOT_NUMBER(001, "숫자를 입력해 주세요."),
    OVER_MAXIMUM_PRICE(002, "한 번에 구입 가능한 최대 금액은 " + Constants.MAXIMUM_PURCHASE_PRICE + "원 입니다."),
    UNDER_MINIMUM_PRICE(003, Constants.PRICE_PER_PIECE + "원 이상 입력해 주세요."),
    NOT_INDIVISIBLE_PRICE(004, Constants.PRICE_PER_PIECE + "원 단위로 입력해 주세요."),
    NOT_IN_NUMBER_RANGE(005, "로또 번호는 " + Constants.MIN_VALUE + "부터 " + Constants.MAX_VALUE + " 사이의 숫자여야 합니다."),
    DUPLICATE_NUM(006, "중복된 값이 있습니다."),
    WINNING_CNT(007, Constants.WINNING_NUMBER_CNT + "개의 값을 입력해 주세요.");

    // enum에서 상수 사용하기 위한 중첩 클래스
    private static class Constants { // 정적 멤버 클래스
        static DecimalFormat df = new DecimalFormat("###,###");

        private static final String MAXIMUM_PURCHASE_PRICE = df.format(LottoValue
                .valueOf("MAXIMUM_PURCHASE_PRICE")
                .getValue());
        private static final String PRICE_PER_PIECE = df.format(LottoValue
                .valueOf("PRICE_PER_PIECE")
                .getValue());
        private static final int MIN_VALUE = LottoValue.valueOf("MIN_VALUE").getValue();
        private static final int MAX_VALUE = LottoValue.valueOf("MAX_VALUE").getValue();
        private static final int WINNING_NUMBER_CNT = LottoValue.valueOf("WINNING_NUMBER_CNT").getValue();
    }

    private int code;
    private String message;

    private ErrorMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ErrorMessage valueOfName(int errorCode) {
        return Arrays.stream(values())
                .filter(value -> value.code == errorCode)
                .findAny()
                .orElse(null);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
