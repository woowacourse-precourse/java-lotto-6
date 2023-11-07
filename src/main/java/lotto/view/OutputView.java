package lotto.view;

import java.util.Collections;
import java.util.List;

public class OutputView {

    public static void printAmount() {
        System.out.println(RequestLine.requestAmount);
    }

    public static void printBuy(int purchasesNumber) {
        System.out.printf(RequestLine.resultBuy.getLine(), purchasesNumber);
    }

    public static void printMyLottos(List<List<Integer>> myLottos) {
        for (List<Integer> myLotto : myLottos) {
            System.out.println(myLotto);
        }
    }

    public static void printNumbers() {
        System.out.println(RequestLine.requestLotto);
    }

    public static void printBonus() {
        System.out.println(RequestLine.requestBonus);
    }

    public static void printStats() {
        System.out.println(RequestLine.resultStats);
    }

    public static void printDash() {
        System.out.println(RequestLine.hyphen);
    }

    public static void printResult(float rate) {
        System.out.printf(RequestLine.resultRate.getLine(), String.format("%.1f", rate));
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
