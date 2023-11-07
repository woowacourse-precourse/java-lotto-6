package lotto.view;

import lotto.model.LottoUtil;

public class ErrorMessage {

    private static final String NOT_NUMBER_RANGE =
            "[ERROR] 숫자는 " + LottoUtil.MIN_NUMBER + "부터 " + LottoUtil.MAX_NUMBER + " 사이의 숫자여야 합니다.";
    private static final String NOT_NUMBER_SIZE = "[ERROR] 번호는 6개 입력 가능합니다.";
    private static final String NOT_NUMBER_OVERLAP = "[ERROR] 중복된 숫자를 입력하셨습니다.";
    private static final String INPUT_TYPE_ERROR = "[ERROR] 숫자만 입력해 주세요.";
    private static final String NOT_NATURAL_NUMBER_ERROR = "[ERROR] 금액은 0 초과이어야 합니다.";
    private static final String NOT_DIVISIBLE_NUMBER_ERROR = "[ERROR] 금액은 " + LottoUtil.LOTTO_PRICE + "단위여야 합니다.";

    public static void rangeException() {
        System.out.println(NOT_NUMBER_RANGE);
    }

    public static void sizeException() {
        System.out.println(NOT_NUMBER_SIZE);
    }

    public static void duplicateException() {
        System.out.println(NOT_NUMBER_OVERLAP);
    }

    public static void typeException() {
        System.out.println(INPUT_TYPE_ERROR);
    }

    public static void naturalException() {
        System.out.println(NOT_NATURAL_NUMBER_ERROR);
    }

    public static void divisibleException() {
        System.out.println(NOT_DIVISIBLE_NUMBER_ERROR);
    }
}
