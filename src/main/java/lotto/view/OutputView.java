package lotto.view;

import java.util.List;
import lotto.model.Constants;
import lotto.model.Lotto;
import lotto.model.LottoPrize;

public class OutputView {

    public static void printLottoBuy(int lottoNums) {
        System.out.println(Constants.LINE_SEPARATOR + lottoNums + Constants.LOTTO_BUY_MESSAGE);
    }

    public static void printAllLottoNumber(List<Lotto> lottoTickets) {
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getNumbers());
        }
    }

    public static void printLottoResult(List<Integer> lottoResult) {
        System.out.println(Constants.RESULT_MESSAGE);
        for (int i = LottoPrize.FIFTH.getPrizeRank(); i >= LottoPrize.FIRST.getPrizeRank(); i--) {
            System.out.println(Constants.PRIZE_MESSAGES[i] + lottoResult.get(i) + Constants.COUNT_UNIT);
        }
    }

    public static void printProfitRate(Double profit) {
        System.out.println(Constants.PROFIT_PREFIX + profit + Constants.PROFIT_SUFFIX);
    }

    public static void printErrorMessage(String Message) {
        System.out.println(Constants.ERROR + Message);
    }

}
