package lotto.constant;

import java.text.DecimalFormat;

public class GuideMessage {
    public static final String INPUT_BUY_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNER_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static final String LOTTO_BUY_COUNT = "개를 구매했습니다.";

    public static final String LOTTO_NUMBER_THREE_NUMBER_MATCH = "3개 일치 (" + addNumberFormat(LottoConstant.FIFTH_PLACE_AMOUNT) + "원) - ";
    public static final String LOTTO_NUMBER_FOUR_NUMBER_MATCH = "4개 일치 (" + addNumberFormat(LottoConstant.FOURTH_PLACE_AMOUNT) + "원) - ";
    public static final String LOTTO_NUMBER_FIVE_NUMBER_MATCH = "5개 일치 (" + addNumberFormat(LottoConstant.THIRD_PLACE_AMOUNT) + "원) - ";
    public static final String LOTTO_NUMBER_FIVE_NUMBER_MATCH_AND_BONUS = "5개 일치, 보너스 볼 일치 (" + addNumberFormat(LottoConstant.SECOND_PLACE_AMOUNT) + "원) - ";
    public static final String LOTTO_NUMBER_ALL_NUMBER_MATCH = "6개 일치 (" + addNumberFormat(LottoConstant.FIRST_PLACE_AMOUNT) + "원) - ";


    private static String addNumberFormat(long number) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        return decFormat.format(number);
    }
}
