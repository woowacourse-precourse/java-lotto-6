package lotto.lottoMachineTest;

import lotto.LottoMachine;
import lotto.enums.LottoPrize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.TreeMap;

/*
public double calculateProfit(int lottoCount, TreeMap<LottoPrize, Integer> winningCount) {
    double totalPrice = lottoCount*LOTTO_PRICE;
    double ret = 0;
    for (LottoPrize lottoPrize: LottoPrize.values()) {
        long prizeMoney = lottoPrize.getPrizeMoney();
        ret += winningCount.getOrDefault(lottoPrize, 0)*prizeMoney;
    }
    return ret/totalPrice;
}
*/
public class CalculateProfitTest {
    @Test
    public void 이득_계산이_맞게_나오나() {
        LottoMachine lottoMachine = new LottoMachine(new DecimalFormat("#.##"));
        int lottoCount = 10;
        TreeMap<LottoPrize, Integer> winningCount = new TreeMap<>();
        winningCount.put(LottoPrize.MATCH_5, 1);
        winningCount.put(LottoPrize.MATCH_6, 1);
        double ret = lottoMachine.calculateProfit(lottoCount, winningCount);
        Assertions.assertThat(ret).isEqualTo(200150.0);
    }
}
