package lotto;

import java.util.Collections;
import java.util.List;

public class LottoResultPrinter {
    public void printResult(List<Integer> matchingNumber, int userCost) {
        long totalSum = matchingNumber.get(3) * 5_000 +
                matchingNumber.get(4) * 5_0000 +
                matchingNumber.get(5) * 1_500_000 +
                matchingNumber.get(6) * 2_000_000_000 +
                matchingNumber.get(0) * 30_000_000;
        double totalResult = (double) totalSum / userCost * 100;
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + matchingNumber.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + matchingNumber.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchingNumber.get(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchingNumber.get(0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchingNumber.get(6) + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.\n", totalResult);
    }

    public void printAllLotto(List<Integer> numbers) {
        Collections.sort(numbers);
        System.out.println(numbers);
    }
}
