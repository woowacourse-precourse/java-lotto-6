package lotto.constants;

public class Message {

    public static final String AMOUNT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String USER_LOTTOS_COUNT_MESSAGE = "개 구매했습니다.";
    public static final String WINNING_NUMBER_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_REQUEST_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String LOTTO_RESULT_MESSAGE = "당첨 통계\n---";

    public static final String LOTTO_5_RANK = "3개 일치 (5,000원) - ";
    public static final String LOTTO_4_RANK = "4개 일치 (50,000원) - ";
    public static final String LOTTO_3_RANK = "5개 일치 (1,500,000원) - ";
    public static final String LOTTO_2_RANK = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String LOTTO_1_RANK = "6개 일치 (2,000,000,000원) - ";

    public static String getLottoResult5RankMessage(int count) {
        return LOTTO_5_RANK + count + "개";
    }

    public static String getLottoResult4RankMessage(int count) {
        return LOTTO_4_RANK + count + "개";
    }

    public static String getLottoResult3RankMessage(int count) {
        return LOTTO_3_RANK + count + "개";
    }

    public static String getLottoResult2RankMessage(int count) {
        return LOTTO_2_RANK + count + "개";
    }

    public static String getLottoResult1RankMessage(int count) {
        return LOTTO_1_RANK + count + "개";
    }


    public static String getLottoProfitRate(double profit) {
        String lottoProfit = String.format("%.1f", profit);
        return "총 수익률은 " + lottoProfit + "입니다.";
    }

}
