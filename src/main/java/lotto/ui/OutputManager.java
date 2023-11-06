package lotto.ui;

import lotto.Lotto;
import lotto.Result;

import java.util.List;

import static lotto.Result.*;

public class OutputManager {
    public void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");

        lottos.stream().map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public void printResults(List<Result> results) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        printMatchAndPrize(results);
        printReturns(results);
    }

    public void printReturns(List<Result> results) {
        int totalAmount = results.size() * 1000;
        int totalPrize = results.stream().mapToInt(Result::prize).sum();

        double returns = (double) totalPrize / totalAmount * 100;

        System.out.println("총 수익률은 " + String.format("%.1f%%", returns) + "입니다.");
    }

    public void printMatchAndPrize(List<Result> results) {

        List<Result> prizes = List.of(FIFTH_PRIZE, FOURTH_PRIZE, THIRD_PRIZE, SECOND_PRIZE, FIRST_PRIZE);

        for (Result result : prizes) {
            String match = result.getMatchingNumbers() + "개 일치";
            if (result==SECOND_PRIZE) match += ", 보너스 볼 일치" ;
            String prize = " (" + String.format("%,d", result.prize()) + "원) - ";
            String matchingNum = results.stream().filter(r-> r==result).count() + "개";

            System.out.println(match + prize + matchingNum);
        }
    }
}
