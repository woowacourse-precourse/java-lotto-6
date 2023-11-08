package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;

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
}
