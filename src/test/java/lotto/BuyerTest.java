package lotto;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BuyerTest {

    @DisplayName("6000원으로 6장의 로또를 구매했으므로 로또 6장이 생성")
    @Test
    void makeLotteries() {
        Buyer buyer = new Buyer(6000);
        ArrayList<Lotto> lotteries = buyer.getLotteries();
        assertEquals(6, lotteries.size());
    }

//    @DisplayName("입력된 금액이 1000원 단위가 아니면 예외를 발생")
//    @Test
//    public void calculationAmount() {
//        int price = 1500;
//        Buyer buyer = new Buyer(price);
//
//    }

    @DisplayName("수익률 계산")
    @Test
    void testCalculationEarningRate() {
        Buyer buyer = new Buyer(5000);
        HashMap<Rank, Integer> ranks = new HashMap<>();
        ranks.put(Rank.FIRST, 1); // 1등에 당첨된 경우
        double earningRate = buyer.calculationEarningRate(ranks);
        assertEquals(40000000.0, earningRate); // 2000000000/5000 * 100
    }
}
