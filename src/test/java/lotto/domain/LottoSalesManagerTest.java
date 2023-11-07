package lotto.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoSalesManagerTest {

    @DisplayName("정상적인 로또를 생성하는지 확인합니다.")
    @Test
    void makeLottosTest() {
        //개수 테스트
        Assertions.assertThat(new LottoSalesManager("6000").makeLottos().size()).isEqualTo(6);
    }

    @DisplayName("올바른 등수를 반환하는지 확인합니다.")
    @ParameterizedTest
    @CsvSource(value = {"3,true,5","4,true,4", "5,false,3","5,true,2","6,true,1"}, delimiter = ',')
    void judgeLottosRankTest(int matchedNumber, boolean bonusIsMatched, int expected){
        Assertions.assertThat(LottoSalesManager.judgeLottosRank(matchedNumber,bonusIsMatched)).isEqualTo(expected);
    }
}