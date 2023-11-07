package lotto.global.constant;

public class LottoConstant {

//    로또 관련 상수
    public static final int LOTTO_NUMBER_RANGE_START = 1;
    public static final int LOTTO_NUMBER_RANGE_END = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int LOTTO_PRICE = 1_000;

//    당첨 관련 상수
    public static final int FIRST_PRIZE = 2_000_000_000;
    public static final int SECOND_PRIZE = 30_000_000;
    public static final int THIRD_PRIZE = 1_500_000;
    public static final int FOURTH_PRIZE = 50_000;
    public static final int FIFTH_PRIZE = 5_000;

    public static final int FIRST_RANK_LOTTO_MATCHED = 6;
    public static final int SECOND_RANK_LOTTO_MATCHED = 6;
    public static final int THIRD_RANK_LOTTO_MATCHED = 5;
    public static final int FOURTH_RANK_LOTTO_MATCHED = 4;
    public static final int FIFTH_RANK_LOTTO_MATCHED = 3;

    public static final String PRINT_FIRST_RANK = "6개 일치 (2,000,000,000원) - ";
    public static final String PRINT_SECOND_RANK = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String PRINT_THIRD_RANK = "5개 일치 (1,500,000원) - ";
    public static final String PRINT_FOURTH_RANK = "4개 일치 (50,000원) - ";
    public static final String PRINT_FIFTH_RANK = "3개 일치 (5,000원) - ";
}
