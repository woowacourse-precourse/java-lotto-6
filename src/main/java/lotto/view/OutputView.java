package lotto.view;

import lotto.Lotto;

import java.util.List;
import java.util.stream.Collector;

public class OutputView {
    private static final String LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_WINNING_STATISTICS_MESSAGE = "당첨 통계.";
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";

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
        System.out.println(lottoTickets.size()+PURCHASE_MESSAGE);
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



}
