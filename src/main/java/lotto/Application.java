package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();
        int purchaseNum = InputAmount.calculate(Integer.parseInt(amount));

        System.out.println(purchaseNum + "개를 구매했습니다.");
        Lotto.publish(purchaseNum);

        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNum = Console.readLine();

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();

        System.out.println("당첨 통계");
        System.out.println("---");
        Lotto.compare(InputWinningNum.input(winningNum, bonus));
        System.out.println("총 수익률은 " + Lotto.revenue(Integer.parseInt(amount)) + "%입니다.");
    }
}
