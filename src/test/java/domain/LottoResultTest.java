package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import constants.LottoWinningPrice;
import java.math.BigDecimal;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void init(){
        lottoResult = new LottoResult();
    }

    @Test
    @DisplayName("3등 1장 + 4등 2장 당첨 = 총 당첨금액 105,000원")
    void createTotalProfitTest(){
        //given
        lottoResult.setLottoResultCount(3,false);
        lottoResult.setLottoResultCount(4,false);
        lottoResult.setLottoResultCount(4,false);

        //when
        BigDecimal totalProfit = lottoResult.createTotalProfit(lottoResult);

        //then
        assertThat(totalProfit.toString()).isEqualTo("105000");
    }


    @DisplayName("배열에 담긴 값은 로또 당첨 금액과 같다")
    @ParameterizedTest
    @ValueSource(strings = {"5000","50000","1500000","30000000","2000000000"})
    void getBigDecimalLottoPricesTest(String price) {
        // given
        BigDecimal[] lottoPrices = Arrays.stream(LottoWinningPrice.values())
                .map(winningPrice -> new BigDecimal(winningPrice.getPrice()))
                .toArray(BigDecimal[]::new);

        // when
        boolean isEquals= false;
        for (BigDecimal lottoPrice : lottoPrices) {
            isEquals = lottoPrice.toString().equals(price);
            if (isEquals) break;
        }

        //then
        assertThat(isEquals).isTrue();
    }

}
