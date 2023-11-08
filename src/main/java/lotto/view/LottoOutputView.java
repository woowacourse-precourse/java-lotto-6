package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constant.Message;
import lotto.constant.UnitNumber;
import lotto.constant.Winning;

public class LottoOutputView {
    public static void printLottoPurchaseCount(int count) {
        lineBreak();
        System.out.println(count + Message.PURCHASE_COUNT.getMessage());
    }

    public static void printLottoNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNumbers);
    }

    public static void printWinningStatistics(Map<Winning, Integer> prize) {
        lineBreak();
        System.out.println(Message.WINNING_STATISTICS.getMessage());
        System.out.println(Message.WINNING_LINE_BREAK.getMessage());

        for(Winning rank : Winning.values()) {
            System.out.println(rank.getPrizeMessage() + Message.INFOR_SEPARATOR.getMessage()
                    + prize.get(rank)
                    + Message.MATCHED_LOTTO_NUMBER_UNITS.getMessage());
        }
    }

    public static void printRateOfReturn(double rate) {
        rate = (double) Math.round(rate * UnitNumber.ROUNDED_HELPER_NUMBER.getNumber())
                / UnitNumber.ROUNDED_HELPER_NUMBER.getNumber();
        System.out.println(Message.RATE_OF_RETURN_SUBJECT.getMessage()
                + rate + Message.RATE_OF_RETURN_UNITS.getMessage()
                + Message.RATE_OF_RETURN_VERB.getMessage());
    }

    public static void lineBreak() {
        System.out.print(Message.LINE_BREAK.getMessage());
    }
}
