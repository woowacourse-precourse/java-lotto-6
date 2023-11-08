package lotto;

import java.text.DecimalFormat;

import static lotto.Application.lottoTickets;
import static lotto.Application.winningNumbers;

public class Calculation {
    static int totalPrizeAmount = 0;
    public static Integer calculatePrizeAmount(int numberOfMatches, boolean hasBonus) {
        int prizeAmount = Prize.matchPrize(numberOfMatches, hasBonus);
        return prizeAmount;
    }
    public static void calculateProfitRate() {
        int totalPurchase = lottoTickets.size() * 1000;
        float profitRate = ((float) totalPrizeAmount / totalPurchase) * 100;
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        String formattedProfitRate = decimalFormat.format(profitRate);
        System.out.println("총 수익률은 "+formattedProfitRate+"%입니다.");
    }
    public static void compareLottoWithWinning(Integer bonusNumber) {
        for(Lotto lottoTicket : lottoTickets) {
            Integer numberOfMatches = (int) lottoTicket.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean hasBonus = lottoTicket.getNumbers().contains(bonusNumber);
            totalPrizeAmount += calculatePrizeAmount(numberOfMatches,hasBonus);



        }
    }
}
