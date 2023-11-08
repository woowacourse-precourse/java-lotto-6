package lotto.view;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.enums.Message;
import lotto.enums.Prize;
import lotto.model.LottoTickets;

public class OutputView {
    public static void printPurchasedLottoTickets(int lottoAmount, LottoTickets lottoTickets) {
        System.out.println();
        System.out.println(lottoAmount + Message.OUTPUT_PURCHASE_AMOUNT.getMessage());
        System.out.println(lottoTickets.toString());
    }

    public static void printEachResults(Map<Integer, Long> eachResults) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(Message.OUTPUT_LOTTO_RESULT_STATS.getMessage());
        Prize[] prizes = Prize.values();
        for (int i = 1; i < prizes.length; i++) {
            Prize prize = prizes[i];
            stringBuilder.append(Message.valueOf(prize.name()).getMessage())
                    .append(eachResults.getOrDefault(prize.getPrize(), 0L))
                    .append("개\n");
        }
        System.out.print(stringBuilder);
    }

    public static void printReturnRate(double lottoReturnRate) {
        DecimalFormat decimalFormat = new DecimalFormat("###,##0.0");
        String formattedReturnRate = decimalFormat.format(lottoReturnRate);
        System.out.println("총 수익률은 " + formattedReturnRate + "%입니다.");
    }
}
