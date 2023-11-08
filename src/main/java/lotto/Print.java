package lotto;

public class Print {
    private static final String LOTTO_COUNT_PRINT_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_RESULT_MESSAGE = "당첨 통계\n---";
    private static final String FIFTH_RESULT_MESSAGE = "3개 일치 (5,000원) - ";
    private static final String FOURTH_RESULT_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String THIRD_RESULT_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String SECOND_RESULT_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String FIRST_RESULT_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private static final String REVENUE_RATE_MESSAGE = "총 수익률은 ";

    public void printLottoCount(int count) {
        System.out.println(count + LOTTO_COUNT_PRINT_MESSAGE);
    }

    public void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public void printResult(int firstCount, int secondCount, int thirdCount, int fourthCount, int fifthCount) {
        System.out.println(LOTTO_RESULT_MESSAGE);
        System.out.println(FIFTH_RESULT_MESSAGE + fifthCount + "개");
        System.out.println(FOURTH_RESULT_MESSAGE + fourthCount + "개");
        System.out.println(THIRD_RESULT_MESSAGE + thirdCount + "개");
        System.out.println(SECOND_RESULT_MESSAGE + secondCount + "개");
        System.out.println(FIRST_RESULT_MESSAGE + firstCount + "개");
    }

    public void printRevenueRate(String revenueRate) {
        System.out.println(REVENUE_RATE_MESSAGE + revenueRate + "%입니다.");
    }
}
