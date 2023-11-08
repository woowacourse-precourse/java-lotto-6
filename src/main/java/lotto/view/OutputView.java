package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void quantityInformationMessage(int quantity) {
        System.out.println();
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printLotto(List<Integer> numbers) {
        System.out.println("[" + numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")) + "]");
    }


    public static void winningStatisticsInformationMessage() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
