package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.Controll.Reward;
import lotto.Controll.SameNumber;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Output {
    static void printInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    static void printTicketsBought(Lotto... tickets) {
        System.out.println(tickets.length + "개를 구매했습니다.");
        printTickets(tickets);
    }

    private static void printTickets(Lotto... tickets) {
        String output = Arrays.asList(tickets).stream()
                .map(Lotto::toList)
                .map(List::toString)
                .collect(Collectors.joining("+" + System.lineSeparator()));
        System.out.println(output);
    }

    static void printInputWinnerNumber() {
        System.out.println(System.lineSeparator() + "당첨 번호를 입력해 주세요.");
    }

    static void printInputBonusNumber() {
        System.out.println(System.lineSeparator() + "보너스 번호를 입력해 주세요.");
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

    static Integer calculateReward(Map<SameNumber, Integer> sameNumberCount) {
        Integer rewardSum = 0;
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
        Controll controll = new Controll();
        Map<SameNumber, Integer> sameNumberCount = controll.countSameNumber(winnerTicket, bonusNumber, tickets);
        printAllSameNumberResult(sameNumberCount);
        Integer earned = calculateReward(sameNumberCount);
        Integer spent = tickets.length * 1000;
        System.out.println(calculateEarningRatio(spent, earned));
    }

    // 당첨 통계
    // ---
    // 3개 일치 (5,000원) - 1개
    // 4개 일치 (50,000원) - 0개
    // 5개 일치 (1,500,000원) - 0개
    // 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    // 6개 일치 (2,000,000,000원) - 0개
    // 총 수익률은 62.5%입니다.

    private static String calculateEarningRatio(Integer spent, Integer earned) {
        DecimalFormat format = new DecimalFormat("#.##");
        format.setRoundingMode(RoundingMode.CEILING);
        return format.format((float) earned / spent);
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
}