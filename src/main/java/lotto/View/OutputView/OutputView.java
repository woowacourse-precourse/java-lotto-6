package lotto.View.OutputView;

import java.util.List;
import java.util.Map;
import lotto.Common.LottoValue;
import lotto.Model.Lotto.Lotto;
import lotto.Model.LottoSet.LottoSet;
import lotto.Model.LottoWinningResult.LottoWinningResult;
import static lotto.Common.LottoValue.*;

public class OutputView {
    private static final String LOTTO_BUY_COUNT = "%2d 개를 구매했습니다.";
    private static final String WINNING_PROFIT  = "당첨 통계";


    public void lottoSetPrint(LottoSet lottoSet) {
        List<Lotto> lottoList = lottoSet.getLottoSet();
        System.out.printf((LOTTO_BUY_COUNT) +"%n",lottoList.size());
        for (Lotto lotto : lottoList) {
            System.out.print("[");
            List<Integer> numbers = lotto.getNumbers();
            lottoNumberPrint(numbers);
            System.out.println("]");
        }
    }

    private void lottoNumberPrint(List<Integer> numbers) {

        int size = numbers.size();

        for (int i = 0; i < size; i++) {
            System.out.print(numbers.get(i));
            if (i < size - 1) {
                System.out.print(",");
            }
        }
    }

    public void profitRatePrint(LottoWinningResult lottoWinningResult){
        System.out.println(WINNING_PROFIT);

        Map<Integer, List<Lotto>> winningLottoList = lottoWinningResult.getMatchingResults();

        for (int matchingNumbers = 3; matchingNumbers <= 6; matchingNumbers++) {
            List<Lotto> lottoList = winningLottoList.get(matchingNumbers);
            int prize = getMultiplier(matchingNumbers);
            if(matchingNumbers == 5) {
                winningLottoCountPrint(matchingNumbers,prize,lottoList);
                System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n", matchingNumbers, prize, winningLottoList.get(7).size());
            }

            if (lottoList != null) {
                winningLottoCountPrint(matchingNumbers,prize,lottoList);
            }
            if(lottoList == null){
                winningLottoCountPrint(matchingNumbers,prize,lottoList);
            }
        }
    }

    private void winningLottoCountPrint (int matchingNumbers , int prize, List<Lotto> lottoList){

        System.out.printf("%d개 일치 (%,d원) - %d개%n", matchingNumbers, prize, lottoList.size());
    }


}
