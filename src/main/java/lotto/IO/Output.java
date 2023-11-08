package lotto.IO;

import static lotto.constant.Constants.BONUS_BALL;
import static lotto.constant.Constants.MONEY_WHEN_FIVE_MATCHED;
import static lotto.constant.Constants.MONEY_WHEN_FIVE_PLUS_BONUS_BALL_MATCHED;
import static lotto.constant.Constants.MONEY_WHEN_FOUR_MATCHED;
import static lotto.constant.Constants.MONEY_WHEN_SIX_MATCHED;
import static lotto.constant.Constants.MONEY_WHEN_THREE_MATCHED;

import java.util.List;
import java.util.Map;
import lotto.Lotto;

public class Output {


    public void requestMoneyOutput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void responseBuyOutput(int count, List<Lotto> lottos) {
        System.out.println(count + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public void requestWinnerNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void responseCalculateWinners(Map<Integer, Integer> winners, double profit) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 " + MONEY_WHEN_THREE_MATCHED + " - " + winners.get(3).toString() + "개");
        System.out.println("4개 일치 " + MONEY_WHEN_FOUR_MATCHED + " - " + winners.get(4).toString() + "개");
        System.out.println("5개 일치 " + MONEY_WHEN_FIVE_MATCHED + " - " + winners.get(5).toString() + "개");
        System.out.println(
                "5개 일치, 보너스 볼 일치 " + MONEY_WHEN_FIVE_PLUS_BONUS_BALL_MATCHED + " - " + winners.get(5 + BONUS_BALL)
                        .toString() + "개");
        System.out.println("6개 일치 " + MONEY_WHEN_SIX_MATCHED + " - " + winners.get(6).toString() + "개");
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", profit));
    }


}
