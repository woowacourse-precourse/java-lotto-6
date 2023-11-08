package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> winningNumbers = new ArrayList<>();
    public static ArrayList<Lotto> lottoTickets = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해주세요.");
        LottoTickets.generateLottoTickets(readInput.readPurchase());
        LottoTickets.showLottoTickets();
        System.out.println("당첨번호를 입력해 주세요.");
        WinningNumberAndBonusNumber.generateWinningNumbers(readInput.readWinningNumbers());
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNumber= WinningNumberAndBonusNumber.generateBonusNumber(readInput.readBonusNumber());
        Calculation.compareLottoWithWinning(bonusNumber);
        System.out.println("당첨 통계");
        System.out.println("---");
        ShowPrize.showPrizeCount();
        Calculation.calculateProfitRate();
    }
}
