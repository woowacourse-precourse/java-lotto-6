package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OutputView {
    private static OutputView outputView = new OutputView();

    private OutputView() {

    }

    public static OutputView getInstance() {
        return outputView;
    }

    public void printIssueNumbers(List<Integer>[] issueNumbers, int count) {
        System.out.println("\n"+count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            System.out.println(issueNumbers[i]);
        }
    }

    public void printResult(int[] sameNumberCount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + sameNumberCount[3] + "개");
        System.out.println("4개 일치 (50,000원) - " + sameNumberCount[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + sameNumberCount[5] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + sameNumberCount[7] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sameNumberCount[6] + "개");
    }

    public void printRate(float rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n",rate);
    }
}
