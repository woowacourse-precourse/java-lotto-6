package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String LOTTO_WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 ";

    public static void printLottoPurchaseAmountMessage(){
        System.out.println(LOTTO_PURCHASE_AMOUNT_MESSAGE);
    }
    public static void printLottoWinningNumberMessage(){
        System.out.println(LOTTO_WINNING_NUMBER_MESSAGE);
    }
    public static void printLottoBonusNumberMessage(){
        System.out.println(LOTTO_BONUS_NUMBER_MESSAGE);
    }
    public static void printLottoWinningStatisticsMessage(){
        System.out.println(LOTTO_WINNING_STATISTICS_MESSAGE);
    }
    public static void printUserPurchase(List<Lotto> lottoTickets){
        System.out.println("\n"+lottoTickets.size()+PURCHASE_MESSAGE);
        for(Lotto lotto : lottoTickets){
            String ticket = generateLottoTicket(lotto);
            System.out.println(ticket);
        }
    }
    private static String generateLottoTicket(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        List<String> toString = numbers.stream()
                .map(Object::toString)
                .toList();
        return "[" + String.join(", ", toString) + "]";
    }
    public static void printLottoStatistics(HashMap<Prize, Integer> gameResult){
        System.out.println(Prize.THREE_MATCH.getPrintMessage() + gameResult.get(Prize.THREE_MATCH) + "개");
        System.out.println(Prize.FOUR_MATCH.getPrintMessage() + gameResult.get(Prize.FOUR_MATCH) + "개");
        System.out.println(Prize.FIVE_MATCH.getPrintMessage() + gameResult.get(Prize.FIVE_MATCH) + "개");
        System.out.println(Prize.FIVE_MATCH_WITH_BONUS.getPrintMessage() + gameResult.get(Prize.FIVE_MATCH_WITH_BONUS) + "개");
        System.out.println(Prize.SIX_MATCH.getPrintMessage() + gameResult.get(Prize.SIX_MATCH) + "개");
    }

    public static void printLottoProfitRate(double profitRate){
        System.out.println(PROFIT_RATE_MESSAGE + profitRate+ "%입니다.");
    }

}
