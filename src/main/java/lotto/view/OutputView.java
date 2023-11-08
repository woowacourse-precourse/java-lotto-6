package lotto.view;

import java.util.stream.Collectors;
import lotto.constants.Prize;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Quantity;

public class OutputView {
    private static final String MSG_RESULT = "당첨 통계";
    private static final String MSG_DIVISION = "---";
    private static final String MSG_PURCHASE = "%d개를 구매했습니다.";
    private static final String MSG_PROFIT = "총 수익률은 %.1f%%입니다.";

    private static final String COUNT_NOUN = "개";
    private static final String NEW_LINE = "\n";
    private static final String DASH = " - ";

    private OutputView() {
    }
    
    public static void printQuantityOfLotteries(Quantity quantity) {
        System.out.printf(MSG_PURCHASE + NEW_LINE, quantity.getAmount());
    }

    public static void printBoughtLottos(Lottos lottos) {
        String boughtLottos = lottos.getPackOfLotteryTickets().stream()
                .map(lotto -> lotto.getNumbers() + "")
                .collect(Collectors.joining(NEW_LINE));
        System.out.println(boughtLottos);
    }

    public static void printResult(LottoResult result) {
        StringBuilder output = new StringBuilder();
        output.append(MSG_RESULT).append(NEW_LINE).append(MSG_DIVISION).append(NEW_LINE);
        for (Prize prize : Prize.values()) {
            long prizeCount = result.getResult().getOrDefault(prize, 0L);
            if (prize != Prize.NO_LUCK) {
                output.append(String.format("%s%s%d%s%s", prize.getMessage(), DASH, prizeCount, COUNT_NOUN, NEW_LINE));
            }
        }
        System.out.print(output.toString());
    }

    public static void printProfit(double profit) {
        System.out.printf(MSG_PROFIT + NEW_LINE, profit);
    }
}
