package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoSet;

import java.util.Map;

public class OutputView {
    private static final String LOTTO_NUM_MESSAGE = "\n%d개를 구매했습니다.\n";

    public static void outputLottoNum(int lottoNum){
        System.out.printf(LOTTO_NUM_MESSAGE, lottoNum);
    }

    public static void outputLottoSet(LottoSet lottoSet){
        for(Lotto lotto : lottoSet.getLottoSet()){
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static Integer outputLottoResult(LottoResult lottoResult){
        System.out.println("\n당첨 통계");
        System.out.println("---");
        Integer money = 0;
        for(Map.Entry<LottoRank, Integer> entry : lottoResult.getLottoResult().entrySet()){
            LottoRank rank = entry.getKey();
            Integer hit = entry.getValue();
            money += rank.getWinningMoney() * hit;
            if(rank != LottoRank.MISS) {
                System.out.println(rank.getMessage() + hit + "개");
            }
        }
        return money;
    }

    public static void outputLottoProfit(Integer earnMoney, Integer lottoBuyMoney){
        double lottoProfit = ((double)(earnMoney) / (lottoBuyMoney)) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", lottoProfit) + "%입니다.");
    }
}
