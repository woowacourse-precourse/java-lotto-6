package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Output {
    void printInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    void printTicketsBought(Lotto... tickets) {
        ticketsCountCheck(tickets);
        System.out.println(tickets.length + "개를 구매했습니다.");
        printTickets(tickets);
    }

    private void ticketsCountCheck(Lotto... tickets) {
        if (tickets.length <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private void printTickets(Lotto... tickets) {
        String output = Arrays.asList(tickets).stream()
                .map(Lotto::toList)
                .map(List::toString)
                .collect(Collectors.joining("+" + System.lineSeparator()));
        System.out.println(output);
    }

    private void printInputWinnerNumber() {
        System.out.println(System.lineSeparator() + "당첨 번호를 입력해 주세요.");
    }

    private void printInputBonusNumber() {
        System.out.println(System.lineSeparator() + "보너스 번호를 입력해 주세요.");
    }

    private void printStatistic(Lotto winner, Integer bonus, Lotto... tickets) {
        Controll controller = new Controll();
        Integer earned = 0;
        System.out.println(System.lineSeparator() + "당첨 통계");
        System.out.println("---");
        for (int i = 0; i < tickets.length; i++) {
            controller.sameNumberCount(winner, tickets[i]);
        }

        System.out.println(calculateEarningRatio(tickets.length * 1000, earned));
    }

    // 당첨 통계
    // ---
    // 3개 일치 (5,000원) - 1개
    // 4개 일치 (50,000원) - 0개
    // 5개 일치 (1,500,000원) - 0개
    // 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    // 6개 일치 (2,000,000,000원) - 0개
    // 총 수익률은 62.5%입니다.

    private String calculateEarningRatio(Integer spent, Integer earned) {
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