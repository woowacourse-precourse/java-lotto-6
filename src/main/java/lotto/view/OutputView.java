package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Prize;

public class OutputView {

    public static void printConstantMessage(ConstantMessage constantMessage) {
        System.out.println(constantMessage.getMessage());
    }

    public static <T> void printListWithNewLine(List<T> messages) {
        messages.forEach(System.out::println);
        printNewLine();
    }

    private static void printNewLine() {
        System.out.println();
    }

    public void printLottos(List<Lotto> lottos) {
        printNewLine();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers().toString()));
        printNewLine();
    }

    public void printPrize(Map<Prize, Integer> prizes) {
        System.out.println("당첨 통계");
        System.out.println("---");

        prizes.forEach((prize, count) -> {
            if (prize != Prize.NONE) {
                String bonusMatch = prize.getMatchBonus() ? ", 보너스 볼 일치" : "";
                System.out.println(
                        "%개 일치%s (%d원) - %d개".formatted(prize.getMatchCount(), bonusMatch, prize.getPrizeMoney(),
                                count));
            }
        });
    }

    public void printEarningRate(double earningRate) {
        System.out.println("총 수익률은 %.2f입니다.".formatted(earningRate));
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
