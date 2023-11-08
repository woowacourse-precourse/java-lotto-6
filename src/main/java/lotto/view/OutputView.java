package lotto.view;

import lotto.Result;

import java.util.List;

public class OutputView {
    private static OutputView outputView = new OutputView();

    private OutputView() {

    }

    public static OutputView getInstance() {
        return outputView;
    }

    public void printIssueNumbers(List<Integer>[] issueNumbers, int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            System.out.println(issueNumbers[i]);
        }
    }

    public void printResult() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (Result result : Result.values()) {
            System.out.println(result.getText() + result.getCount() + "개");
        }
    }

    public void printRate(float rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rate);
    }
}
