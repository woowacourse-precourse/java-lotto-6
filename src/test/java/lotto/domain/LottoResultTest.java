package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

class LottoResultTest {

    LottoResult lottoResult;

    @BeforeEach
    public void before() {
        lottoResult = new LottoResult();
    }

    @DisplayName("등수 결과 추가하기")
    @Test
    public void 등수_결과_추가() throws Exception {
        //given (주어진 값)
        int zero = 0;
        int one = 1;
        int two = 2;
        int three = 3;
        int four = 4;
        int five = 5;
        int fiveAndBonus = 50;
        int six = 6;

        lottoResult.addWinningCount(zero);
        lottoResult.addWinningCount(one);
        lottoResult.addWinningCount(two);
        lottoResult.addWinningCount(three);
        lottoResult.addWinningCount(four);
        lottoResult.addWinningCount(five);
        lottoResult.addWinningCount(fiveAndBonus);
        lottoResult.addWinningCount(six);
        lottoResult.addWinningCount(six);

        //when (기능 작동)
        Map<Integer, Integer> resultCount = lottoResult.getWinningCount();

        //then (기능 작동 후 결과)
        Assertions.assertThat(resultCount.get(3)).isEqualTo(1);
        Assertions.assertThat(resultCount.get(4)).isEqualTo(1);
        Assertions.assertThat(resultCount.get(5)).isEqualTo(1);
        Assertions.assertThat(resultCount.get(50)).isEqualTo(1);
        Assertions.assertThat(resultCount.get(6)).isEqualTo(2);
    }

    @DisplayName("수익률 계산하기")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,0", "2,0", "3,5000", "4,50000", "5,1500000", "50, 30000000", "6, 2000000000"}, delimiter = ',')
    public void 수익률_계산(int number, int money) throws Exception {
        //given (주어진 값)
        double expect = ((double) money / 1000) * 100;

        //when (기능 작동)
        lottoResult.addTotalWinningMoney(number);
        lottoResult.calculateProfitMargin(1000);
        double result = lottoResult.getProfitMargin();

        //then (기능 작동 후 결과)
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @DisplayName("당첨이 2개일 때 수익률 계산하기")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,0", "2,0", "3,5000", "4,50000", "5,1500000", "50, 30000000", "6, 2000000000"}, delimiter = ',')
    public void 중복_2개의_당첨_수익률_계산(int number, int money) throws Exception {
        //given (주어진 값)
        double expect = ((double) money * 2 / 2000) * 100;

        //when (기능 작동)
        lottoResult.addTotalWinningMoney(number);
        lottoResult.addTotalWinningMoney(number);
        lottoResult.calculateProfitMargin(2000);
        double result = lottoResult.getProfitMargin();

        //then (기능 작동 후 결과)
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @DisplayName("당첨이 3개일 때 수익률 계산하기")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,0", "2,0", "3,5000", "4,50000", "5,1500000", "50, 30000000", "6, 2000000000"}, delimiter = ',')
    public void 중복_3개의_당첨_수익률_계산(int number, int money) throws Exception {
        //given (주어진 값)
        double expect = ((double) money * 3 / 3000) * 100;

        //when (기능 작동)
        lottoResult.addTotalWinningMoney(number);
        lottoResult.addTotalWinningMoney(number);
        lottoResult.addTotalWinningMoney(number);
        lottoResult.calculateProfitMargin(3000);
        double result = lottoResult.getProfitMargin();

        //then (기능 작동 후 결과)
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @DisplayName("여러개의 당첨 수익률 계산하기")
    @Test
    public void 여러개의_당첨_수익률_계산() throws Exception {
        //given (주어진 값)
        int two = 2;
        int three = 3;
        int five = 5;
        int fiveAndBonus = 50;
        int six = 6;

        long money = 0+5000+1500000+30000000+2000000000;
        double expect = ((double) money / 5000) * 100;

        //when (기능 작동)
        lottoResult.addTotalWinningMoney(two);
        lottoResult.addTotalWinningMoney(three);
        lottoResult.addTotalWinningMoney(five);
        lottoResult.addTotalWinningMoney(fiveAndBonus);
        lottoResult.addTotalWinningMoney(six);
        lottoResult.calculateProfitMargin(5000);

        double result = lottoResult.getProfitMargin();

        //then (기능 작동 후 결과)
        Assertions.assertThat(result).isEqualTo(expect);
    }
}