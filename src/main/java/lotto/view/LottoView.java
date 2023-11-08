package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.StatisticsDto;

public class LottoView {

    public static int requestMoneyToUser() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();

        return Integer.parseInt(input);
    }

    public static void printPurchaseList(List<Lotto> purchased) {
        StringBuilder sb = new StringBuilder();
        sb.append(purchased.size()).append("개를 구매했습니다.\n");
        for (Lotto lotto : purchased) {
            sb.append(lotto.getImmutableSortedNumbers());
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static List<Integer> requestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();

        return Arrays
                .stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public static int requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();

        return Integer.parseInt(input);
    }

    public static void printStatistics(StatisticsDto statistics) {
        double ratio = Math.round(statistics.getProfitRatio() * 10) / 10.0;
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n")
                .append("---\n")
                .append("3개 일치 (5,000원) - ").append(statistics.getFifthPlaceLottoCount()).append("개")
                .append("\n")
                .append("4개 일치 (50,000원) - ").append(statistics.getFourthPlaceLottoCount()).append("개")
                .append("\n")
                .append("5개 일치 (1,500,000원) - ").append(statistics.getThirdPlaceLottoCount()).append("개")
                .append("\n")
                .append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(statistics.getSecondPlaceLottoCount()).append("개")
                .append("\n")
                .append("6개 일치 (2,000,000,000원) - ").append(statistics.getFirstPlaceLottoCount()).append("개")
                .append("\n")
                .append("총 수익률은 ").append(ratio).append("%입니다.");
        System.out.println(sb);
    }
}
