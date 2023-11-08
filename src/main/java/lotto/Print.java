package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Print {
    public static void roundEarningRate(float earningRate){
        System.out.print(String.format("총 수익률은 " + "%.1f", earningRate) + "%입니다.");
    }

    enum LottoResult {
        FIFTH(3, 5000, "3개 일치 (5,000원) - "), FOURTH(4, 50000, "4개 일치 (50,000원) - "), THIRD(5, 1500000, "5개 일치 (1,500,000원) - "), SECOND(55, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - ");
        private final int correctNumber;
        private final int reward;
        private final String value;
        LottoResult(int correctNumber, int reward, String value) {
            this.correctNumber = correctNumber;
            this.reward = reward;
            this.value = value;
        }
    }

    public static int LottoResult(List<Integer> correctCounts){
        int totalReward = 0;

        for(LottoResult lr:LottoResult.values()){
            System.out.println(lr.value + Collections.frequency(correctCounts, lr.correctNumber) + "개");
            if(Collections.frequency(correctCounts, lr.correctNumber) != 0){
                totalReward += lr.reward;
            }
        }
        return totalReward;
    }

    enum Message {
        GetPurchasePrice(0, "구입금액을 입력해 주세요."), PrintPurchaseCount(1, "개를 구매했습니다."), GetWinningNumber(2, "당첨 번호를 입력해 주세요."), GetBonusNumber(3, "보너스 번호를 입력해 주세요."), WinningStatus(4, "당첨 통계"), Bar(5, "---");
        private final int index;
        private final String value;
        Message(int index, String value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void message(int n){
        for(Message msg:Message.values()){
            if(msg.index == n){
                System.out.println(msg.value);
            }
        }
    }

    public static void sortedLottoNumber(List<Lotto> lottos){
        for(Lotto l:lottos) {
            List<Integer> lottoElement = new ArrayList<Integer>(l.getter());
            lottoElement.sort(Comparator.naturalOrder());
            System.out.println(lottoElement);
        }
        System.out.println();
    }
}
