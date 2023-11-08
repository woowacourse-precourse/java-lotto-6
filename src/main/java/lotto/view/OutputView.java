package lotto.view;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import lotto.constants.Constants;
import lotto.domain.Lotto;
import lotto.domain.Reward;

public class OutputView {

    DecimalFormat decimalFormat = new DecimalFormat("###,###");
    public void showLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottosNumber());
        }
    }

    public void showWinning() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
    public void showPrizes(EnumMap<Reward,Integer> prizes){
        for (Reward reward : Reward.values()) {
            if (reward.getCount() == Constants.ZERO) {
                continue;
            }
            if (reward.equals(Reward.MATCH_FIVE_BONUS)) {
                System.out.println(
                        reward.getCount() + "개 일치, 보너스 볼 일치 " + "(" + decimalFormat.format(reward.getPrize()) + "원)"
                                + " - " + prizes.get(reward) + "개");
                continue;
            }
            System.out.println(
                    reward.getCount() + "개 일치 " + "(" + decimalFormat.format(reward.getPrize()) + "원)" + " - "
                            + prizes.get(reward) + "개");
        }
    }
    public void showEarningRate(int money, int prizeSum){
        double earningRate = 0;
        earningRate = Math.round((((double) prizeSum / money) * Constants.HUNDRED)* Constants.HUNDRED)/ Constants.DOUBLEHUNDRED;
        System.out.println("총 수익률은 " + earningRate +"%입니다.");
    }

}

