package lotto.View;

import java.util.HashMap;
import java.util.List;
import lotto.Constants.LottosConstants;
import lotto.Domain.Lotto;

public class OutputView {
    private static final String BUY_MESSAGE = "개를 구매했습니다.";
    private static final String START_WINNING_COUNT = "당첨 통계\n---";
    private static final String ROI_MESSAGE = "총 수익률은 %s%%입니다.";

    public void printBuyMessage(int amount, List<Lotto> lottoPapers){
        System.out.println(amount + BUY_MESSAGE);
        printLottoPapers(lottoPapers);
        printSpace();
    }
    private void printLottoPapers(List<Lotto> lottoPapers){
        for (Lotto lotto : lottoPapers){
            System.out.println(lotto.getNumbers());
        }
    }

    private void printSpace(){
        System.out.println();
    }
}
