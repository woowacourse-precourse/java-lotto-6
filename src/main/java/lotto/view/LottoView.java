package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class LottoView {
    private final Scanner scanner;

    public LottoView() {
        this.scanner = new Scanner(System.in);
    }

    public int getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public void printNumberOfPurchasedTickets(int count) {
        System.out.printf("%d개를 구매했습니다.%n", count);
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = scanner.next();
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return scanner.nextInt();
    }

    public void printWinningResults(List<String> results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (String result : results) {
            System.out.println(result);
        }
    }

    public void printTotalProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
