package lotto.model;

import static lotto.constant.Numbers.LOTTOPRICE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomLottosTest {
    @Test
    void checkRandomLottosSize(){
        LottoAmountofMoney lottoAmountofMoney = new LottoAmountofMoney("10000");
        Integer lottoMoney = lottoAmountofMoney.getLottoAmountofMoney();
        Integer lottoTicketNumber = lottoMoney / LOTTOPRICE.getIntValue();
        RandomLottos randomLottos = new RandomLottos(lottoAmountofMoney);
        assertThat(randomLottos.getRandomLottos().size()).isEqualTo(lottoTicketNumber);

    }

}