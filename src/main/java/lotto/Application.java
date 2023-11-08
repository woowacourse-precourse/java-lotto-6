package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            int purchaseAmount = Integer.parseInt(Console.readLine("구입금액을 입력해 주세요."));
            LottoTicket lottoTicket = LottoTicket.purchase(purchaseAmount);

            System.out.println(lottoTicket.getTickets().size() + "개를 구매했습니다.");
            lottoTicket.printTickets();

            WinningNumbers winningNumbers = WinningNumbers.inputWinningNumbers();
            int bonusNumber = Integer.parseInt(Console.readLine("보너스 번호를 입력해 주세요."));
            lottoTicket.calculateAndPrintResult(winningNumbers, bonusNumber);

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
