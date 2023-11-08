package model;


public class LottoUtils {
    protected static final int LOTTO_NUMBER_SIZE = 6;
    protected static final int MIN_LOTTO_NUMBER = 1;
    protected static final int MAX_LOTTO_NUMBER = 45;
    public static final int FIRST_PRIZE = 7;
    public static final int SECOND_PRIZE = 6;
    public static final int THIRD_PRIZE = 5;
    public static  final int FOURTH_PRIZE = 4;
    public static final int FIFTH_PRIZE = 3;
    public static final int LOTTO_PRICE = 1000;

    protected static boolean isOutOfLottoRange(int number) {
        return (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER);
    }

    protected static boolean isInvalidLottoSize(int number) {
        return (number != LOTTO_NUMBER_SIZE);
    }
}
