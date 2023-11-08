package lotto.utils;

import java.util.HashMap;
import java.util.Map;

public class Constant {
    public static final String numberRegex = "\\d+";
    public static final int START_INCLUSIVE = 1;
    public static final int END_ENCLUSIVE = 45;
    public static final int LOTTO_NUMBER = 6;
    public static final Map<Integer, String> lottoResult = Map.of(
            6, "six",
            5, "five",
            4, "four",
            3, "three",
            7, "bonus"
    );
}
