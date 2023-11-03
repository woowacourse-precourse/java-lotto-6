package lotto;

import java.util.List;

public class DataOutput {
    public static final String inputPaymentMessage = "구입금액을 입력해 주세요.";
    public static final String buyLottoAmountMessage = "개를 구매했습니다.";
    public static final String inputWinningNumberMessage = "당첨 번호를 입력해 주세요.";
    public static final String inputBonusNumberMessage = "보너스 번호를 입력해 주세요.";
    public static final String winningStatisticsMessage = "당첨 통계";
    public static final String inningStatisticsThreeMessage = "3개 일치 (5,000원) - ";
    public static final String inningStatisticsFourMessage = "4개 일치 (50,000원) - ";
    public static final String inningStatisticsFiveMessage = "5개 일치 (1,500,000원) - ";
    public static final String inningStatisticsFiveBonusMessage = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String inningStatisticsSixMessage = "6개 일치 (2,000,000,000원) - ";

    public void printPurchaseLottoNumbers(List<Integer> lottoNumbers){
        String toPrint = "[" + lottoNumbers.get(0);

        for(int i = 1; i < lottoNumbers.size(); i++){
            toPrint = toPrint + ", " + lottoNumbers.get(i);
        }
        toPrint += "]";

        System.out.println(toPrint);
    }
}
