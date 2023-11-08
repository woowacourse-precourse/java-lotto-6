package View;

import Model.Prize;
import Model.PrizeResult;
import java.text.DecimalFormat;
import java.util.List;
import lotto.Lotto;

public class OutputView {
    private DecimalFormat decimalFormat = new DecimalFormat("###,###");

    public void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] : " + errorMessage);
    }

    public void printRandomGeneratedPurchsedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printLottoResult(PrizeResult prizeResult) {
        System.out.println("당첨통계");
        System.out.println("---");
        for (Prize prize : Prize.values()) {
            String bonusPhrase = "";
            if (prize.equals(Prize.MISS)) {
                continue;
            }
            if (prize.equals(Prize.SECOND)) {
                bonusPhrase = ", 보너스 볼 일치";
            }
            int matchCount = prizeResult.getPrize(prize);
            int prizeMoney = prize.getMoney();
            int matchAmount = prize.getMatchAmount();
            System.out.println(
                    matchAmount + "개 일치" + bonusPhrase + " (" + decimalFormat.format(prizeMoney) + "원)" + " - "
                            + matchCount + "개");
        }
    }

    public void printReturnRate(double rate) {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
