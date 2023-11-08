package lotto.view;

import lotto.domain.WinningRank;
import lotto.domain.dto.BuyLottoInfo;
import lotto.domain.dto.LottoWinResult;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String DELIMITER = "---";
    private static final String TOTAL_ERAN_RATE = "총 수익률은 %s%%입니다.\n";


    public void printUserLottoInfo(BuyLottoInfo buyLottoInfo){
        System.out.println(buyLottoInfo.getLottoTicketCount() + "개를 구매했습니다.");
        for (List<Integer> numbers : buyLottoInfo.getUserLottoNumbers()){
            System.out.println(numbers);
        }
        System.out.println();
    }

    public void printLottoResult(LottoWinResult lottoWinResult){
        Map<WinningRank, Integer> winningRankCount = lottoWinResult.getWinningRankCount();
        double rateOfReturn = lottoWinResult.rateOfReturn();

        System.out.println(WINNING_STATISTICS);
        System.out.println(DELIMITER);
        winningRankCount.forEach((winningRank, count) -> {
            if(winningRank != WinningRank.NO_LUCK){
                System.out.printf(winningRank.getMessage(), count);
            }
        });
        System.out.printf(TOTAL_ERAN_RATE, String.format("%.1f", rateOfReturn));
    }

    public void printError(String errorMessage){
        System.out.println(errorMessage);
    }
}
