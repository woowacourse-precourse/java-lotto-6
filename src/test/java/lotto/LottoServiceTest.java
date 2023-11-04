package lotto;

import static lotto.Constant.BUY_UNIT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoServiceTest {
    @DisplayName("로또 구매금액에 따른 구매개수를 반환해주는 기능.")
    @ParameterizedTest
    @ValueSource(longs = {1000,5000,0,100000,18000})
    void 로또_구매_개수(long buyCash){
        LottoService lottoService =new LottoService();
        long expected=buyCash/BUY_UNIT;

        assertThat(lottoService.getLottoAmount(buyCash)).isEqualTo(expected);
    }

    @DisplayName("총 수익과 구매금액을 통해 수익률을 반환해주는 기능.")
    @Test
    void 수익률_반환(){
        //given
        LottoService lottoService =new LottoService();
        long totalProfit=5000;
        long buyCash=8000;
        double expected=62.5;

        //when
        double result= lottoService.getTotalProfitRate(totalProfit,buyCash);

        //then
        assertThat(result).isEqualTo(expected);
    }
}