package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoSet;

import java.util.Map;

public class OutputView {
    private static final String LOTTO_QUANTITY_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String LOTTO_RESULT_ANNOUNCE_MESSAGE = "\n당첨 통계";
    private static final String LOTTO_RESULT_UNDERBAR_MESSAGE = "---";
    private static final String LOTTO_RESULT_HIT_MESSAGE = "개";
    private static final String LOTTO_RESULT_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.\n";
    public static void outputLottoNum(int lottoQuantity){
        System.out.printf(LOTTO_QUANTITY_MESSAGE, lottoQuantity);
    }

    public static void outputLottoSet(LottoSet lottoSet){
        for(Lotto lotto : lottoSet.getLottoSet()){
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static Integer outputLottoResult(LottoResult lottoResult){
        System.out.println(LOTTO_RESULT_ANNOUNCE_MESSAGE);
        System.out.println(LOTTO_RESULT_UNDERBAR_MESSAGE);
        Integer money = 0;
        for(Map.Entry<LottoRank, Integer> entry : lottoResult.getLottoResult().entrySet()){
            LottoRank rank = entry.getKey();
            Integer hit = entry.getValue();
            money += rank.getWinningMoney() * hit;
            if(rank != LottoRank.MISS) {
                System.out.println(rank.getMessage() + hit + LOTTO_RESULT_HIT_MESSAGE);
            }
        }
        return money;
    }

    public static void outputLottoProfit(Integer earnMoney, Integer lottoBuyMoney){
        double lottoProfit = ((double)(earnMoney) / (lottoBuyMoney)) * 100;
        System.out.printf(LOTTO_RESULT_PROFIT_MESSAGE, lottoProfit);
    }
}
