package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class LottoMachineTest {
    private static final long LOTTO_TICKET_PRICE = 1000L;

    @DisplayName("입력한 금액에 따른 로또 생성 테스트")
    @Test
    void createLotto() {
        long money = 14000;
        long total_lotto_count = money / LOTTO_TICKET_PRICE;

        List<Lotto> lottoList = LottoMachine.make(money);
        Assertions.assertThat(lottoList.size()).isEqualTo(total_lotto_count);
    }


}