package lotto;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String error = "[ERROR]";
    private static int LottoNum;
    public static void main(String[] args) {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String amount = Console.readLine();
            LottoNum = Amount.calAmount(Integer.parseInt(amount));

            System.out.println(LottoNum + "개를 구매했습니다.");
            Lotto.publish(LottoNum);

            System.out.println("당첨 번호를 입력해 주세요.");
            String winningNum = Console.readLine();

            System.out.println("보너스 번호를 입력해 주세요.");
            String bonus = Console.readLine();

            System.out.println("당첨 통계");
            System.out.println("---");
            Lotto.compare(InputWinnerLotto.input(winningNum, bonus));
            System.out.printf("총 수익률은 %.1f", Lotto.revenue(Integer.parseInt(amount)));
            System.out.print("%입니다.");
        } catch (NumberFormatException e) {
            System.out.println(error + " 숫자를 입력해주세요.");
        }
    }
}
