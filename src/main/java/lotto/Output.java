package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Output {
    static void printInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    static void printTicketsBought(Lotto... tickets) {
        System.out.println(System.lineSeparator() + tickets.length + "개를 구매했습니다.");
        printTickets(tickets);
    }

    private static void printTickets(Lotto... tickets) {
        String output = Arrays.asList(tickets).stream()
                .map(Lotto::toList)
                .map(List::toString)
                .collect(Collectors.joining(" " + System.lineSeparator()));
        System.out.println(output);
    }

    static void printInputWinnerNumber() {
        System.out.println(System.lineSeparator() + "당첨 번호를 입력해 주세요.");
    }

    static void printInputBonusNumber() {
        System.out.println(System.lineSeparator() + "보너스 번호를 입력해 주세요.");
    }

    private static String calculateEarningRatio(Long spent, Long earned) {
        return "총 수익률은 " + formatPoint((float) earned / spent * 100) + "%입니다.";
    }

    private static String formatPoint(float number) {
        DecimalFormat format = new DecimalFormat("#.##");
        format.setRoundingMode(RoundingMode.CEILING);
        return format.format(number);
    }

    private static String formatComma(Integer number) {
        DecimalFormat format = new DecimalFormat("#,###");
        return format.format(number);
    }

    static void printSameNumberResult(SameNumber sameNumber, Integer count) {
        System.out.print(SameNumber.toInteger(sameNumber) + "개 일치");
        if (sameNumber.equals(SameNumber.SAME5BONUS)) {
            System.out.print(", 보너스 볼 일치");
        }
        Integer reward = Reward.fromSameNumber(sameNumber);
        if (count == null) {
            count = 0;
        }
        System.out.println(" (" + formatComma(reward) + "원) - " + count + "개");
    }

    static void printAllSameNumberResult(Map<SameNumber, Integer> sameNumberCount) {
        for (SameNumber sameNumber : SameNumber.values()) {
            if (sameNumber != SameNumber.SAME0) {
                printSameNumberResult(sameNumber, sameNumberCount.get(sameNumber));
            }
        }
    }

    static Long calculateReward(Map<SameNumber, Integer> sameNumberCount) {
        Long rewardSum = 0L;
        for (SameNumber sameNumber : sameNumberCount.keySet()) {
            Integer reward = Reward.fromSameNumber(sameNumber);
            Integer count = sameNumberCount.get(sameNumber);
            rewardSum += reward * count;
        }
        return rewardSum;
    }

    static void printStatistic(Lotto winnerTicket, Integer bonusNumber, Lotto... tickets) {
        System.out.println(System.lineSeparator() + "당첨 통계");
        System.out.println("---");
        Control control = new Control();
        Map<SameNumber, Integer> sameNumberCount = control.getCompareResult(winnerTicket, bonusNumber, tickets);
        printAllSameNumberResult(sameNumberCount);
        Long earned = calculateReward(sameNumberCount);
        Long spent = control.moneyForTickets(tickets.length);
        System.out.println(calculateEarningRatio(spent, earned));
    }
}