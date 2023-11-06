package lotto.view;
import lotto.model.Player;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printBuyLotto(List<List<Integer>> mainLotto, int count) {
        System.out.println(count + "개를 구매했습니다.");
        for (List<Integer> lotto: mainLotto) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printNumbers(List<Integer> numbers) {
        String output = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
        System.out.println(output);
        System.out.println();
    }

    public static void printBonusNumber(String bonusNumber) {
        System.out.println(bonusNumber);
        System.out.println();
    }

    public static void printWinningResultPreFace() {
        System.out.println("당첨통계\n---");
    }

    public static void printWinningResult(String sentence, int matchCount) {
        System.out.println(sentence + " " + matchCount + "개");

    }

    public static void printWinningTotal(Player player) {
        int price = player.getPrice();
        long total = player.getTotal();
        double divTotal = (double) (total - price) / price;
        System.out.printf("총 수익률은 %.1f%%입니다.", (100 + divTotal * 100));
    }
}
