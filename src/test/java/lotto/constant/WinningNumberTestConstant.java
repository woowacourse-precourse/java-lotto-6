package lotto.constant;

import java.util.List;

public class WinningNumberTestConstant {
    public static final String WINNING_NUMBER = "1,2,3,4,5,6";
    public static final String INVALID_TYPE_WINNING_NUMBER = "1,6,10,22,35,a";
    public static final String INVALID_RANGE_WINNING_NUMBER = "1,19,25,36,45,50";
    public static final String DUPLICATION_WINNING_NUMBER = "1,19,25,36,45,45";
    public static final String LESS_SIZE_WINNING_NUMBER = "1,3,6,19,22";
    public static final String EXCEED_SIZE_WINNING_NUMBER = "1,3,6,19,22,25,36,45";
    public static final List<Integer> WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
}
