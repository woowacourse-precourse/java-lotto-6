package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> winningNumbers = new ArrayList<>();
    public static ArrayList<Lotto> lottoTickets = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(MessageUtil.MSG_INPUT_PURCHASE);
        LottoTickets.generateLottoTickets(readInput.readPurchase());
        LottoTickets.showLottoTickets();
        System.out.println(MessageUtil.MSG_INPUT_WINNING_NUMBER);
        WinningNumberAndBonusNumber.generateWinningNumbers(readInput.readWinningNumbers());
        System.out.println(MessageUtil.MSG_INPUT_BONUS_NUMBER);
        Integer bonusNumber= WinningNumberAndBonusNumber.generateBonusNumber(readInput.readBonusNumber());
        Calculation.compareLottoWithWinning(bonusNumber);
        System.out.println(MessageUtil.MSG_WINNING_STATICS);
        System.out.println(MessageUtil.DIVIDE_LINE);
        ShowPrize.showPrizeCount();
        Calculation.calculateProfitRate();
    }
}
