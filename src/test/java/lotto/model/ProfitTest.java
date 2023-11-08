package lotto.model;

import lotto.entity.Prize;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class ProfitTest {
    Profit profit;
    @BeforeEach
    void setUp() {
        profit = new Profit();
        profit.init();
    }

    @AfterEach
    void tearDown() {
    }
    @DisplayName("0개 당첨된경우")
    @Test
    void Invalid(){
        Prize first = Prize.FIRST;
        Prize second = Prize.SECOND;
        Prize third = Prize.THIRD;
        Prize fourth = Prize.FOURTH;
        Prize fifth = Prize.FIFTH;
        assertEquals(profit.getProfit(),0);
    }
    @DisplayName("1개 당첨된경우")
    @Test
    void Invalid2(){
        Prize first = Prize.FIRST;
        Prize second = Prize.SECOND;
        Prize third = Prize.THIRD;
        Prize fourth = Prize.FOURTH;
        Prize fifth = Prize.FIFTH;
        profit.updateProfitRate(first);
        assertEquals(profit.getProfit(),2000000000);
    }
    @DisplayName("1개 당첨된경우 이익률")
    @Test
    void Invalid3(){
        Prize first = Prize.FIRST;
        Prize second = Prize.SECOND;
        Prize third = Prize.THIRD;
        Prize fourth = Prize.FOURTH;
        Prize fifth = Prize.FIFTH;
        double result = 200000000.0;
        profit.updateProfitRate(first);
        assertEquals(profit.getProfitRate(),result);
    }
    @DisplayName("1개 당첨된경우 소비 총액")
    @Test
    void Invalid4(){
        Prize first = Prize.FIRST;
        Prize second = Prize.SECOND;
        Prize third = Prize.THIRD;
        Prize fourth = Prize.FOURTH;
        Prize fifth = Prize.FIFTH;
        profit.updateProfitRate(first);
        profit.updateProfitRate(first);
        profit.updateProfitRate(first);
        profit.updateProfitRate(first);
        profit.updateProfitRate(first);

        assertEquals(profit.getAmount(),5000);
    }
}