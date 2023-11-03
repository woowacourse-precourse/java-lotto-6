package lotto;

import java.util.List;

public class PrintSystem {
    private static final String INPUT_PAYMENT_ACCOUNT_MESSAGE = "구입금액을 입력해주세요";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String PRINT_RESULT_TOTAL_NUM_OF_LOTTO = "를 구매했습니다.";
    private static final String PRINT_WINNING_STATISTICS_MESSAGE = "당첨 통계\n---";
    private static final String PRINT_3_MATCH_RESULT_MESSAGE = "3개 일치 (5,000원) - ";
    private static final String PRINT_4_MATCH_RESULT_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String PRINT_5_MATCH_RESULT_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String PRINT_5_MATCH_AND_BONUS_MATCH_RESULT_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String PRINT_6_MATCH_RESULT_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private static final String PRINT_TOTAL_RATE_OF_REVENUE_FRONT = "총 수익률은 ";
    private static final String PRINT_TOTAL_RATE_OF_REVENUE_BACK = "입니다.";
    private static final String COUNT_UNIT = "개";
    private static final String PERCENT_UNIT = "%";

    public void printAskPaymentAccount(){
        System.out.println(INPUT_PAYMENT_ACCOUNT_MESSAGE);
    }

    public void printNumOfLotto(int numOfLotto){
        System.out.println(numOfLotto + COUNT_UNIT + PRINT_RESULT_TOTAL_NUM_OF_LOTTO);
    }

    public void printGeneratedLottos(List<Lotto> lottos){
        for(Lotto lotto:lottos){
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public void printResultWinningStatisticsAndRateOfRevenue(List<Integer> results,double rateRevenue){
        System.out.println(PRINT_WINNING_STATISTICS_MESSAGE);
        System.out.println(PRINT_3_MATCH_RESULT_MESSAGE + results.get(0) + COUNT_UNIT);
        System.out.println(PRINT_4_MATCH_RESULT_MESSAGE + results.get(1) + COUNT_UNIT);
        System.out.println(PRINT_5_MATCH_RESULT_MESSAGE + results.get(2) + COUNT_UNIT);
        System.out.println(PRINT_5_MATCH_AND_BONUS_MATCH_RESULT_MESSAGE + results.get(3) + COUNT_UNIT);
        System.out.println(PRINT_6_MATCH_RESULT_MESSAGE + results.get(4) + COUNT_UNIT);

        System.out.println(PRINT_TOTAL_RATE_OF_REVENUE_FRONT+String.format("0.1f",rateRevenue)+PERCENT_UNIT+PRINT_TOTAL_RATE_OF_REVENUE_BACK);
    }

}
