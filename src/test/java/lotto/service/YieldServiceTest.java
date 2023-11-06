package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class YieldServiceTest {

    YieldService yieldService;

    @BeforeEach
    void init(){
        yieldService=new YieldService();
    }

    @Test
    @DisplayName("수익률 계산 로직 테스트!")
    void calculateYieldTest() {
        //given
        Long result=5000L;
        Long money=8000L;

        //when
        double calculateResult = yieldService.calculateYield(result, money);

        //then
        Assertions.assertThat(calculateResult).isEqualTo(62.5f);
    }
}