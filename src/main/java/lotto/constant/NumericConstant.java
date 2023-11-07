package lotto.constant;

public abstract class NumericConstant {
    public static final int DIGIT_COUNT_LIMIT = 9; // 자릿수가 9를 넘어가는 자연수(ex.10억)는 입력받지 않음. (overflow 방지)
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
}