package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    private final LottoResult result = new LottoResult();
    private int price = 5000;
    @DisplayName("총 수익과 수익률을 계산해서 알려준다.")
    @Test
    void calculateRateOfReturn() {
        result.increaseCountOfRank(5);
        double rate = result.calculateRateOfProfit(price);

        Assertions.assertEquals(100.,rate);
        Assertions.assertEquals(5000,result.getProfit());

        result.increaseCountOfRank(2);
        rate = result.calculateRateOfProfit(price);

        Assertions.assertEquals(600100.,rate);
        Assertions.assertEquals(30005000,result.getProfit());
    }

    @DisplayName("당첨 내역 저장이 잘 되는지 확인")
    @Test
    void checkWinningDetails() {
        result.increaseCountOfRank(1);
        Assertions.assertEquals(1,result.getCountOfRank(1));
    }
}