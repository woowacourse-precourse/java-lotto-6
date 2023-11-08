package lotto.view;

import java.util.Map;
import lotto.model.LottoTicket;
import lotto.model.Prize;

public class LottoOutputView {

    public static final String MESSAGE_TICKETS_PURCHASED = "%d개를 구매했습니다.";
    public static final String HEADER_STATISTICS = "당첨 통계";
    public static final String MESSAGE_TOTAL_YIELD = "총 수익률은 %.1f%%입니다.";
    public static final String CONTOUR = "---";

    public void printLottoEntries(LottoTicket lottoTicket) {
        String message = String.format(MESSAGE_TICKETS_PURCHASED,
            lottoTicket.getLottoEntries().size());
        System.out.println(message);
        System.out.println(lottoTicket);
        System.out.println();
    }

    public void print(String input) {
        System.out.println(input);
    }

    public void printResult(Map<Prize, Integer> prizeMap, double totalMoney) {
        System.out.println(HEADER_STATISTICS);
        System.out.println(CONTOUR);
        double prizeMoney = 0;
        for (Prize prize : Prize.values()) {
            if (prize != Prize.NONE) {
                Integer count = prizeMap.getOrDefault(prize, 0);
                System.out.println(prize.createMessage(count));
                prizeMoney += (prize.getPrizeMoney() * count);
            }
        }
        double result = calculateYield(prizeMoney, totalMoney);
        System.out.printf((MESSAGE_TOTAL_YIELD), result);
    }

    private double calculateYield(double prizeMoney, double totalMoney) {
        double yield = (prizeMoney / totalMoney) * 100;
        return roundToTwoDecimalPlaces(yield);
    }

    public double roundToTwoDecimalPlaces(double value) {
        return (Math.round(value * 100.0) / 100.0);
    }
}
