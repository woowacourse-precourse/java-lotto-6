package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

public class LottoBuyerTest {
    @Test
    void 로또_금액을_받으면_로또_가격에_따른_구입한_로또_개수가_나타나야_함(){
        //given
        String givenLottoMoney = "5000";
        int givenLottoCount = 5;
        //when
        LottoBuyer lottoBuyer = LottoBuyer.fromString(givenLottoMoney);
        int lottoCount = lottoBuyer.getLottoCount();
        
        //then
        assertThat(lottoCount).isEqualTo(givenLottoCount);
    }

    @Test
    void 수익율_계산을_위해_계산할_수_있는_금액_반환해야_함(){
        //given
        String givenLottoMoney = "5000";
        BigDecimal givenLottoBuyMoney = new BigDecimal("5000");
        
        //when
        LottoBuyer lottoBuyer = LottoBuyer.fromString(givenLottoMoney);
        BigDecimal lottoBuyMoney = lottoBuyer.getBuyingMoney();

        //then
        assertThat(lottoBuyMoney).isEqualTo(givenLottoBuyMoney);
    }
}
