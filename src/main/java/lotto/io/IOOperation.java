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
    public static Integer getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        Integer price;

        while (true) {
            try {
                price = Integer.parseInt(Console.readLine());
                Checker.priceCorrect(price);
            } catch (NumberFormatException e){
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return price;
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = new ArrayList<>();

        while (true) {
            try {
                String input = Console.readLine();
                Arrays.asList(input.split(",")).forEach((value) -> {winningNumbers.add(Integer.parseInt(value));});
                Checker.winningSix(winningNumbers);
                Checker.winningInRange(winningNumbers);
                Checker.winningNotDuplicated(winningNumbers);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
                winningNumbers.clear();
                continue;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                winningNumbers.clear();
                continue;
            }
            break;
        }
        return winningNumbers;
    }

    public static Integer getBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNumber;

        while (true) {
            try {
                bonusNumber = Integer.parseInt(Console.readLine());
                Checker.bonusInRange(bonusNumber);
                Checker.winningAndBonusNotDuplicated(winningNumbers, bonusNumber);
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해 주세요.");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return bonusNumber;
    }

    public static void printLottos(List<Lotto> lottos) {
        Integer numberOfLotto = lottos.size();

        System.out.println(numberOfLotto + "개를 구매했습니다.");

        lottos.forEach((lotto) -> {
            lotto.print();
        });
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

        Double rateOfReturn = Judge.rateOfReturn(rankings, price);
        String formattedReturn = String.format("%.1f", rateOfReturn);
        System.out.println("총 수익률은 " + formattedReturn + "%입니다.");
    }
}
