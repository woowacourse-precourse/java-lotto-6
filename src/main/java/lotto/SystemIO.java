package lotto;

import lotto.ENUM.ExceptionCase;
import lotto.ENUM.WinningRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class SystemIO {
    public static String requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine();
    }

    public static List<Integer> requestWinningNumber() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                return readWinningNumbers();
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> readWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        List<String> stringWinningNumbers = Arrays.asList(readLine().split(","));
        for (String stringWinningNumber : stringWinningNumbers) {
            try {
                winningNumbers.add(Integer.parseInt(stringWinningNumber));
            } catch (NumberFormatException e) {
                throw new IllegalStateException(ExceptionCase.WINNING_NUMBER_IS_NOT_INTEGER.getErrMessage());
            }
        }
        for (Integer winningNumber : winningNumbers) {
            if (!(winningNumbers.indexOf(winningNumber) == winningNumbers.lastIndexOf(winningNumber))) {
                throw new IllegalStateException();
            }
        }
        return winningNumbers;
    }

    public static int requestBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                return readBonusNumber();
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private static int readBonusNumber() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalStateException(ExceptionCase.BONUS_NUMBER_IS_NOT_INTEGER.getErrMessage());
        }
    }

    public static void showTickets(Map<Integer, List<Integer>> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (List<Integer> ticket : tickets.values()) {
            System.out.println(ticket);
        }
    }

    public static void showResult(Map<WinningRank, Integer> winningTally, Long winningAmount, String purchaseAmount) {
        Double rateOfReturn = (Double.valueOf(winningAmount) / Double.valueOf(purchaseAmount)) * 100;
        System.out.println("당첨 통계");
        System.out.println("---");
        showWinningAmountEachRank(winningTally, WinningRank.FIFTH_WINNING);
        showWinningAmountEachRank(winningTally, WinningRank.FOURTH_WINNING);
        showWinningAmountEachRank(winningTally, WinningRank.THIRD_WINNING);
        showWinningAmountEachRank(winningTally, WinningRank.SECOND_WINNING);
        showWinningAmountEachRank(winningTally, WinningRank.FIRST_WINNING);
        System.out.println("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");
    }

    public static void showWinningAmountEachRank(Map<WinningRank, Integer> winningTally, WinningRank winningRank) {
        System.out.printf(winningRank.getConditionsForWinning());
        System.out.printf(" (" + winningRank.getLotteryWinningAmount() + "원) - ");
        System.out.println(winningTally.get(winningRank) + "개");
    }
}
