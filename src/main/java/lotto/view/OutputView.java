package lotto.view;

import java.util.Collections;
import java.util.List;

public class OutputView {

    private static final String inputAmount = "구입금액을 입력해 주세요.";
    private static final String buy = "\n%d개를 구매했습니다.\n";
    private static final String inputNumbers = "\n당첨 번호를 입력해 주세요.";
    private static final String inputBonus = "\n보너스 번호를 입력해 주세요.";
    private static final String stats = "\n당첨 통계";
    private static final String dash = "---";
    private static final String result = "총 수익률은 %s%%입니다.";

    public static void printAmount() {
        System.out.println(inputAmount);
    }

    public static void printBuy(int purchasesNumber) {
        System.out.printf(buy, purchasesNumber);
    }

    public static void printMyLottos(List<List<Integer>> myLottos) {
        for (List<Integer> myLotto : myLottos) {
            System.out.println(myLotto);
        }
    }

    public static void printNumbers() {
        System.out.println(inputNumbers);
    }

    public static void printBonus() {
        System.out.println(inputBonus);
    }

    public static void printStats() {
        System.out.println(stats);
    }

    public static void printDash() {
        System.out.println(dash);
    }

    public static void printResult(float rate) {
        System.out.printf(result, String.format("%.1f", rate));
    }

    public static void eachResult(List<Integer> matchingLotto) {
        int match = 3; // 3개 맞은 것부터 출력
        for (OutputLine outputLine : OutputLine.values()) {
            if (match == 6) {
                System.out.printf(outputLine.getCorrect(), Collections.frequency(matchingLotto, 10));
                match++;
                continue;
            }
            if (match > 6) {
                match = 6;
            }
            System.out.printf(outputLine.getCorrect(), Collections.frequency(matchingLotto, match++));
        }
    }


}
