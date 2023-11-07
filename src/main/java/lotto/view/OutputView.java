package lotto.view;

import lotto.domain.LottoGrade;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PRINT_LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PRINT_COUNT_PURCHASE_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final String PRINT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String PRINT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTIC_MESSAGE = "당첨 통계";
    private static final String DIVISION_LINE = "---";
    private static final String RETURN_RATE_FORMAT = "###,##0.0";


    public void printLottoPurchaseAmountInputMessage() {
        System.out.println(PRINT_LOTTO_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printCountPurchaseLotto(int purchaseLottoCount) {
        System.out.println();
        System.out.println(purchaseLottoCount + PRINT_COUNT_PURCHASE_LOTTO_MESSAGE);
    }

    public void printIssuedLottoNumbers(List<Integer> generateLottoNumbers) {
        System.out.println(generateLottoNumbers.toString());
    }

    public void printWinningNumbersInputMessage() {
        System.out.println();
        System.out.println(PRINT_WINNING_NUMBERS_MESSAGE);
    }

    public void printBonusNumberInputMessage() {
        System.out.println();
        System.out.println(PRINT_BONUS_NUMBER_MESSAGE);
    }

    public void printWinningStatisticsMessage() {
        System.out.println();
        System.out.println(WINNING_STATISTIC_MESSAGE);
        System.out.println(DIVISION_LINE);
    }

    public void printLottoStatistic(Map<LottoGrade, Integer> result) {
        System.out.println("3개 일치 (5,000원) - " + result.get(LottoGrade.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.get(LottoGrade.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.get(LottoGrade.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(LottoGrade.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.get(LottoGrade.FIRST) + "개");
    }

    public void printAllReturnRate(double returnRate) {
        DecimalFormat returnRateFormat = new DecimalFormat(RETURN_RATE_FORMAT);
        String formattedReturnRate = returnRateFormat.format(returnRate);
        System.out.println("총 수익률은 " + formattedReturnRate + "%입니다.");
    }
}
