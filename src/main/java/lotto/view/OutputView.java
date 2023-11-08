package lotto.view;

import lotto.model.LottoPurchase;
import lotto.util.Constants;
import lotto.util.message.OutputMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static lotto.util.message.OutputMessage.*;
public class OutputView {
    public void errorMessagePrint(final String errorMessage) {
        System.out.println(errorMessage);
    }
    public void userLotteries(List<LottoPurchase> userLotteries,int count) {
        System.out.println(OUTPUT_PURCHASE_COUNT.getFormattedMessage(count));
        for (LottoPurchase userLottery : userLotteries) {
            System.out.println(userLottery.getUserLottery());
        }
        newLine();
    }
    public void winningResult(final Map<Integer,Integer> winningResult){
        System.out.println(OUTPUT_RESULT.getFormattedMessage(
                winningResult.get(Constants.LottoResult.TREE.getCount()),
                winningResult.get(Constants.LottoResult.FOUR.getCount()),
                winningResult.get(Constants.LottoResult.FIVE.getCount()),
                winningResult.get(Constants.LottoResult.FIVE_AND_BONUS.getCount()),
                winningResult.get(Constants.LottoResult.SIX.getCount())));
    }
    public void winningStatistics(){
        System.out.println(OUTPUT_WINNING_STATISTICS.getOutputMessage());
    }
    public void statistics(double statistics) {
        System.out.println(OUTPUT_TOTAL_RETURN.getFormattedMessage(statistics));
    }
    public void newLine(){
        System.out.println();
    }
}
