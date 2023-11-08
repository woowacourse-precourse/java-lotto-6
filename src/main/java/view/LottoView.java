package view;

import model.LottoResult;

import java.util.List;
import java.util.Scanner;

public class LottoView {
    public void printPurchaseMessage(int numberOfTickets) {
        System.out.println(numberOfTickets + "개를 구매했습니다.");
    }

    public void printLottoTickets(List<List<Integer>> lottoTickets) {
        for (List<Integer> ticket : lottoTickets) {
            System.out.println(ticket);
        }
    }

    public int getInput(String message) {
        int input = -1;
        while (input < 0) {
            try {
                System.out.println(message);
                input = Integer.parseInt(new Scanner(System.in).nextLine());
                if (input < 0) {
                    throw new IllegalArgumentException("음수 값을 입력할 수 없습니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력하세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        return input;
    }

    public void printResults(List<LottoResult> results) {
        int[] prizeCounts = new int[LottoResult.values().length];
        long totalPrizeAmount = 0;

        System.out.println("당첨 통계");
        System.out.println("---");

        for (LottoResult result : LottoResult.values()) {
            int matchingCount = result.getMatchingCount();
            int count = prizeCounts[result.ordinal()];

            if (matchingCount > 0) {
                long prizeAmount = result.getPrizeAmount();
                System.out.println(matchingCount + "개 일치 (" + result.getName() + ") - " + count + "개");
            }
        }

        double profitRate = (totalPrizeAmount / (results.size() * 1000.0)) * 100;
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}

