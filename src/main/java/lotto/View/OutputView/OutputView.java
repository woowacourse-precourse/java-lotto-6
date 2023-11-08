package lotto.View.OutputView;

import java.util.List;
import java.util.Map;
import lotto.Model.Lotto.Lotto;
import lotto.Model.LottoSet.LottoSet;
import lotto.Model.LottoWinningResult.LottoWinningResult;
import lotto.Model.ProfitRate.ProfitRate;

import static lotto.Common.LottoValue.*;

public class OutputView {
    private static final String LOTTO_BUY_COUNT = "%d개를 구매했습니다.\n";
    private static final String WINNING_PROFIT = "당첨 통계";
    private static final String WINNING_LOTTO_PRINT = "%d개 일치 (%,d원) - %d개%n";
    private static final String WINNING_LOTTO_PRINT_WITH_BONUS = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n";
    private static final String COMMA = ", ";
    private static final String RIGHT_BRACKET = "[";
    private static final String LEFT_BRACKET = "]\n";
    private static final String TOTAL_PROFIT_RATE= "총 수익률은 %.1f%%입니다.";




    public void lottoSetPrint(LottoSet lottoSet) {
        List<Lotto> lottoList = lottoSet.getLottoSet();
        System.out.print(" ");
        System.out.printf(LOTTO_BUY_COUNT,lottoList.size());

        for (Lotto lotto : lottoList) {
            System.out.printf(RIGHT_BRACKET);
            List<Integer> numbers = lotto.getNumbers();
            lottoNumberPrint(numbers);
            System.out.printf(LEFT_BRACKET);
        }
    }

    private void lottoNumberPrint(List<Integer> numbers) {

        int size = numbers.size();

        for (int i = 0; i < size; i++) {
            System.out.printf("%d", numbers.get(i));
            if (i < size - 1) {
                System.out.printf(COMMA);
            }
        }

    }

    public void winningLottoPrint(LottoWinningResult lottoWinningResult) {
        System.out.println();
        System.out.println(WINNING_PROFIT);
        System.out.println("---");
        Map<Integer, List<Lotto>> winningLottoList = lottoWinningResult.getMatchingResults();

        for (int matchingNumbers = 3; matchingNumbers <= 6; matchingNumbers++) {
            List<Lotto> lottoList = winningLottoList.get(matchingNumbers);

            withOutBonusNumber(matchingNumbers,lottoList);

            if (matchingNumbers == 5) {
                withBonusNumber(matchingNumbers, winningLottoList);
            }
        }
    }

    private void withBonusNumber(int matchingNumbers , Map<Integer, List<Lotto>> winningLottoList ){
        int bonusPrize = getMultiplier(7);
        int bonusMatches = 0 ;

        if(winningLottoList.get(7) != null) {
            bonusMatches = winningLottoList.get(7).size();
        }

        System.out.printf(WINNING_LOTTO_PRINT_WITH_BONUS, matchingNumbers, bonusPrize, bonusMatches);

    }

    private void withOutBonusNumber( int matchingNumbers , List<Lotto> lottoList){
        int prize = getMultiplier(matchingNumbers);
        int size =0;

        if (lottoList != null) {
            size = lottoList.size();
        }

        System.out.printf(WINNING_LOTTO_PRINT, matchingNumbers, prize, size);

    }

    public void totalProfitRatePrint(ProfitRate profitRate) {
        System.out.printf(TOTAL_PROFIT_RATE,profitRate.getProfitRatePercent());
    }

}
