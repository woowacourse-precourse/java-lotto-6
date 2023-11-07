package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Checker;
import lotto.domain.Judge;
import lotto.domain.Lotto;
import lotto.domain.Ranking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IOOperation {
    private static Integer priceGenerator() {
        try {
            Integer price = Integer.parseInt(Console.readLine());
            Checker.priceCorrect(price);
            return price;

        } catch (NumberFormatException e){
            System.out.println("[ERROR] 숫자를 입력해 주세요.");
            return priceGenerator();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return priceGenerator();
        }
    }

    public static Integer getPrice() {
        System.out.println("구입금액을 입력해 주세요.");

        Integer price = priceGenerator();
        System.out.println();

        return price;
    }

    private static List<Integer> winningGenerator() {
        try {
            List<Integer> winningNumbers = new ArrayList<>();
            String input = Console.readLine();
            Arrays.asList(input.split(",")).forEach((value) -> {winningNumbers.add(Integer.parseInt(value));});
            Checker.winningCorrect(winningNumbers);
            return winningNumbers;

        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요.");
            return winningGenerator();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return winningGenerator();
        }
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = winningGenerator();
        System.out.println();

        return winningNumbers;
    }

    private static Integer bonusGenerator(List<Integer> winningNumbers) {
        try {
            Integer bonusNumber = Integer.parseInt(Console.readLine());
            Checker.bonusCorrect(winningNumbers, bonusNumber);
            return bonusNumber;

        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요.");
            return bonusGenerator(winningNumbers);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return bonusGenerator(winningNumbers);
        }
    }

    public static Integer getBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNumber = bonusGenerator(winningNumbers);
        System.out.println();

        return bonusNumber;
    }

    public static void printLottos(List<Lotto> lottos) {
        Integer numberOfLotto = lottos.size();

        System.out.println(numberOfLotto + "개를 구매했습니다.");

        lottos.forEach((lotto) -> {
            lotto.print();
        });

        System.out.println();
    }

    public static void printResult(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber, Integer price) {
        List<Integer> rankings = Judge.result(lottos, winningNumbers, bonusNumber);

        System.out.println("당첨 통계");
        System.out.println("---");
        for (Integer rank = rankings.size() - 1; rank >= 0; rank--) {
            Integer count = rankings.get(rank);
            String message = Ranking.findRankingByRank(rank + 1).message();

            System.out.println(message + " - " + count + "개");
        }

        printRateOfReturn(rankings, price);
    }

    private static void printRateOfReturn(List<Integer> counts, Integer price) {
        Double rateOfReturn = Judge.rateOfReturn(counts, price);
        String formattedReturn = String.format("%.1f", rateOfReturn);
        System.out.println("총 수익률은 " + formattedReturn + "%입니다.");
    }
}
