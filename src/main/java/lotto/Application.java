package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int purchaseAmount = Integer.parseInt(Console.readLine());
            LottoTicket lottoTicket = LottoTicket.purchase(purchaseAmount);

            System.out.println("\n" + lottoTicket.getTickets().size() + "개를 구매했습니다.");
            lottoTicket.printTickets();

            WinningNumbers winningNumbers = WinningNumbers.inputWinningNumbers();
            WinningStatistic winningStatistic = lottoTicket.calculateResult(winningNumbers);

            winningStatistic.printStatistic();
            System.out.println("총 수익률은 " + winningStatistic.calculateYield(purchaseAmount) + "%입니다.");

        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 금액은 숫자로 입력해주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
