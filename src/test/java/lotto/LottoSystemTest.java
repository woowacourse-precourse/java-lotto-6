package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoSystemTest {
    @Test
    void 구입한_금액이_1000으로_나누었을_떄_나머지가_있는_경우(){
        LottoSystem lottoSystem = new LottoSystem();
        String money = "1100";
        assertThatThrownBy(() -> lottoSystem.buyLottoTicket(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입한_금액이_0인_경우(){
        LottoSystem lottoSystem = new LottoSystem();
        String money = "0";
        assertThatThrownBy(() -> lottoSystem.buyLottoTicket(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입한_금액이_잘못된_경우(){
        LottoSystem lottoSystem = new LottoSystem();
        String money = "1000j";
        assertThatThrownBy(() -> lottoSystem.buyLottoTicket(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

