package lotto.grobal;

import java.util.regex.Pattern;

public class LottoConstants {
    public static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    public static final int LOTTO_PRICE = 1000;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;

    private LottoConstants() {
    }
}
