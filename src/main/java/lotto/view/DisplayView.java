package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;

import java.util.List;
import java.util.Map;

public class DisplayView {

    // 결과를 출력하는 메소드
    public static void displayResults(Map<Prize, Integer> prizeResults) {
        System.out.println(UserMessage.LOTTO_STATISTICS_HEADER);
        for (Prize prize : Prize.values()) {
            if (prize != Prize.NONE) { // 상금이 없는 경우는 출력하지 않음
                displayMatchCountAndPrize(prizeResults, prize);
            }
        }
    }

    private static void displayMatchCountAndPrize(Map<Prize, Integer> prizeResults, Prize prize) {
        String bonusMatchString = " ";
        if (prize.isBonusMatch()) {
            bonusMatchString = ", 보너스 볼 일치 ";
        }
        System.out.println(String.format(UserMessage.MATCH_COUNT_AND_PRIZE_FORMAT,
                prize.getMatchingNumbers(),
                bonusMatchString,
                prize.getPrizeMoney(),
                prizeResults.get(prize)));
    }


    // 로또 티켓을 출력하는 메소드
    public static void displayTickets(List<Lotto> tickets) {
        tickets.forEach(ticket -> System.out.println(ticket.getNumbers()));
    }

    // 구매한 로또 수량을 출력하는 메소드
    public static void displayPurchasedLottoCount(int count) {
        System.out.println(String.format(UserMessage.PURCHASED_LOTTOS_COUNT, count));
    }

    // 수익률을 출력하는 메소드
    public static void displayYield(double yield) {
        System.out.println(String.format(UserMessage.TOTAL_PROFIT_RATE_FORMAT, yield));
    }

    // 기타 사용자에게 보여질 메시지를 출력하는 메소드들...
    public static void displayRequestPurchaseAmount() {
        System.out.println(UserMessage.REQUEST_PURCHASE_AMOUNT);
    }

    public static void displayRequestWinningNumbers() {
        System.out.println(UserMessage.REQUEST_WINNING_NUMBERS);
    }

    public static void displayRequestBonusNumber() {
        System.out.println(UserMessage.REQUEST_BONUS_NUMBER);
    }
}
