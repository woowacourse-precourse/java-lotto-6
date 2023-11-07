package lotto.view;

import lotto.domain.LottoMoney;
import lotto.domain.Prize;

import java.util.List;

public class OutputView {
    private static int[] rank = new int[8];
    public static void winningLotto(List<Integer> numbers, List<List<Integer>> myNumbers) {
        System.out.println();
        for (List<Integer> myNumber : myNumbers) {
            checkLotto(numbers, myNumber);
        }
    }

    public static void viewResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Prize.FIFTH.getPrintResult() + rank[3] + "개");
        System.out.println(Prize.FOURTH.getPrintResult() + rank[2] + "개");
        System.out.println(Prize.THIRD.getPrintResult() + rank[1] + "개");
        System.out.println(Prize.SECOND.getPrintResult() + rank[7] + "개");
        System.out.println(Prize.FIRST.getPrintResult() + rank[0] + "개");
        viewPercentage();
    }

    public static void viewPercentage() {
        int inputMoney = LottoMoney.getInputMoney();
        int prizeMoney = rank[3] * Prize.FIFTH.getPrice() + rank[2] * Prize.FOURTH.getPrice() + rank[1] * Prize.THIRD.getPrice()
                + rank[7] * Prize.SECOND.getPrice() + rank[0] * Prize.FIRST.getPrice();
        float percent = (float) prizeMoney / inputMoney * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", percent) + "%입니다.");
    }

    private static void checkLotto(List<Integer> numbers, List<Integer> myNumber) {
        int checkLottoNum = 0;
        for (int i = 0; i < myNumber.size(); i++) {
            if (numbers.contains(myNumber.get(i))) {
                checkLottoNum++;
            }
        }
        if (checkLottoNum == 5 && myNumber.contains(numbers.get(6))) {
            rank[7]++;
            return;
        }
        rank[6 - checkLottoNum]++;
    }

    public static int[] getRank() {
        return rank;
    }
}
